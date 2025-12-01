package nl.rotterdam.nl_design_system.wicket.html;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * <p>
 * Builds a string of zero or more <a href="https://html.spec.whatwg.org/multipage/common-microsyntaxes.html#set-of-space-separated-tokens">
 * tokens separated by spaces</a>. Usage is similar to {@link StringBuilder}. {@link #use(Consumer)} will only be called
 * if at least 1 token was appended:
 * </p>
 * <pre>
 * new TokenSetBuilder()
 *     .append("an unconditional token")
 *     .append(someCondition, "a conditional token")
 *     .append(someCondition, () -> "an expensive or non-null dependent conditional token")
 *     .use((tokens) -> ...);
 * </pre>
 */
public class TokenSetBuilder {

    private final StringBuilder builder;
    private boolean isFirst = true;

    /**
     * <p>
     * Create an instance with a capacity of 100.
     * </p>
     */
    public TokenSetBuilder() {
        this(100);
    }

    /**
     * <p>
     * Create an instance with the given capacity.
     * </p>
     * @param capacity initial capacity
     */
    public TokenSetBuilder(int capacity) {
        super();
        builder = new StringBuilder(capacity);
    }

    /**
     * <p>
     * Append the given token.
     * </p>
     *
     * @param token the token to append.
     * @return this builder.
     */
    public TokenSetBuilder append(CharSequence token) {
        appendSpaceIfNeeded();
        builder.append(token);

        return this;
    }

    /**
     * <p>
     * Append the given token if the given condition is <code>true</code>. If the token is expensive to generate or is
     * dependent on non-null checks in the condition, use {@link #append(boolean, Supplier)} instead.
     * </p>
     *
     * @param condition whether <code>token</code> should be appended or not.
     * @param token     the token to append if <code>condition</code> is <code>true</code>.
     * @return this builder.
     */
    public TokenSetBuilder append(boolean condition, CharSequence token) {
        if (condition) {
            appendSpaceIfNeeded();

            builder.append(token);
        }

        return this;
    }

    /**
     * <p>
     * Append the token supplied by the given supplier if the given condition is <code>true</code>. Useful for cases
     * where the token is expensive to generate or the token can only be generated if non-null checks in the condition
     * hold.
     * </p>
     *
     * @param condition     whether the token of <code>tokenSupplier</code> should be appended or not.
     * @param tokenSupplier the supplier of the token to append if <code>condition</code> is <code>true</code>.
     * @return this builder.
     */
    public TokenSetBuilder append(boolean condition, Supplier<CharSequence> tokenSupplier) {
        if (condition) {
            appendSpaceIfNeeded();

            builder.append(tokenSupplier.get());
        }

        return this;
    }

    /**
     * <p>
     * Use the built tokens value if it is not empty.
     * </p>
     * @param consumer the consumer of the built tokens.
     */
    public void use(Consumer<String> consumer) {
        if (!builder.isEmpty()) {
            consumer.accept(builder.toString());
        }
    }

    private void appendSpaceIfNeeded() {
        if (isFirst) {
            isFirst = false;
        } else {
            builder.append(' ');
        }
    }
}

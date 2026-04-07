import type { Decorator } from '@storybook/react-vite';
import { useEffect, type CSSProperties } from 'react';

export const StoryRootDecorator: Decorator = (Story, context) => {
  const { dir, lang, storyRootClassname, title, writingMode, zoom } = context.globals;
  const style: CSSProperties = zoom ? { zoom } : {};

  // In Storybook there are different view modes. When looking at all stories,
  // the url is something like: `iframe.html?viewMode=docs&...`
  //
  // When looking at one just one Story, the URL is like: `iframe.html?viewMode=docs&...`
  //
  // Here we will recongnize such an URL, and render the Story settings on page level,
  // to conform to the following WCAG 2.2 Success criteria:
  //
  // - Page title: https://nldesignsystem.nl/wcag/2.4.2
  // - Language of the page: https://nldesignsystem.nl/wcag/3.1.1
  const { viewMode } = context;

  useEffect(() => {
    if (viewMode === 'story') {
      document.title = title || context.name;
      document.documentElement.lang = lang;
      document.documentElement.dir = dir || '';
      document.documentElement.style.writingMode = writingMode || '';
    } else if (viewMode === 'docs') {
      // Restore the title, dir and lang to sensible defaults
      document.title = context.title;
      document.documentElement.lang = 'nl';
      document.documentElement.dir = 'ltr';
      document.documentElement.style.writingMode = 'initial';
    }
  }, [context.name]);

  return (
    <div data-story-root className={storyRootClassname} lang={lang} dir={dir} style={style}>
      <Story />
    </div>
  );
};

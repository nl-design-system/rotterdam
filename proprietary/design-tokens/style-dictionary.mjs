import StyleDictionary from "style-dictionary";
import { typeDtcgDelegate } from "style-dictionary/utils";
import { createConfig } from "./basis-style-dictionary-config.mjs";

const build = async () => {
  //   StyleDictionary.registerPreprocessor({
  //     name: "dtcg-delegate",
  //     preprocessor: typeDtcgDelegate,
  //   });

  const sd = new StyleDictionary({
    ...createConfig({
      prefix: "rotterdam",
    }),
    // preprocessors: ["tokens-studio", "dtcg-delegate"],
    source: ["src/**/*.tokens.json"],
  });

  await sd.cleanAllPlatforms();
  await sd.buildAllPlatforms();
};

build();

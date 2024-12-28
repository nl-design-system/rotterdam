import { register } from "@tokens-studio/sd-transforms";
import StyleDictionary from "style-dictionary";
import { typeDtcgDelegate } from "style-dictionary/utils";
import { createConfig } from "./style-dictionary-config.mjs";

const build = async () => {
  const prefix = "rods";

  StyleDictionary.registerPreprocessor({
    name: "dtcg-delegate",
    preprocessor: typeDtcgDelegate,
  });

  register(StyleDictionary, {
    excludeParentKeys: false,
  });

  let sd = new StyleDictionary({
    ...createConfig({
      className: `${prefix}-theme`,
    }),
    preprocessors: ["tokens-studio", "dtcg-delegate"],
    source: ["./src/**/tokens.json", "./src/**/*.tokens.json"],
  });

  await sd.cleanAllPlatforms();
  await sd.buildAllPlatforms();
};

build();

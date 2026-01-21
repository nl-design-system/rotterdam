# @gemeente-rotterdam/web-components-react

## 1.0.0

### Major Changes

- b149e55: Bump `@stencil/react-output-target` to 1.2.0.

  As a side effect, the entry point to the package is improved and you now have to import the components from the default export.

  ```diff
  -import RodsIconChevronRight from '@gemeente-rotterdam/web-components-react/dist/RodsIconChevronRight';
  +import { RodsIconChevronRight } from '@gemeente-rotterdam/web-components-react';
  ```

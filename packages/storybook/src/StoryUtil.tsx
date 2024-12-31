import { OFLibrary, OpenFormsModule } from '@open-formulieren/sdk';
import { PropsWithChildren, useEffect, useState } from 'react';
import { Form, Formio, Templates } from 'react-formio';
import '@open-formulieren/sdk/styles.css';

export type FormConfiguration = { type: string; components: { type: string; key?: string; label?: string }[] };

const useOpenFormsConfiguration = () => {
  const [isConfigured, setIsConfigured] = useState(Templates.current === OFLibrary);

  useEffect(() => {
    if (!isConfigured && Templates.current !== OFLibrary) {
      Formio.use(OpenFormsModule);
      Templates.current = OFLibrary;
      setIsConfigured(true);
    }
  }, [isConfigured]);

  return isConfigured;
};

const RenderFormioForm = ({ form }: PropsWithChildren<{ form: FormConfiguration }>) => {
  const isConfigured = useOpenFormsConfiguration();

  if (!isConfigured) {
    return null;
  }
  return (
    <Form
      form={form}
      submission={{}}
      options={{
        baseUrl: '',
        evalContext: {
          ofPrefix: 'openforms-',
          requiredFieldsWithAsterisk: false,
        },
        language: 'nl',
        noAlerts: true,
        ofContext: {
          submissionUuid: '426c8d33-6dcb-4578-8208-f17071a4aebe',
        },
      }}
    />
  );
};

type ComponentProperty = string | boolean | number | object | null;

type SingleFormioComponentProps = {
  type: string;
  key?: string;
  label?: string;
  extraComponentProperties?: { [index: string]: ComponentProperty };
};

type MultipleFormioComponentsProps = {
  components: SingleFormioComponentProps[];
};

const mergeExtraComponentProperties = ({
  extraComponentProperties = {},
  key,
  label,
  type,
}: SingleFormioComponentProps): {
  type: string;
  key?: string;
  label?: string;
  [index: string]: unknown;
} => ({
  key,
  label,
  type,
  ...extraComponentProperties,
});

export const SingleFormioComponent = (args: SingleFormioComponentProps) => {
  return <RenderFormioForm form={{ components: [mergeExtraComponentProperties(args)], type: 'form' }} />;
};

export const MultipleFormioComponents = ({ components }: MultipleFormioComponentsProps) => {
  return <RenderFormioForm form={{ components, type: 'form' }} />;
};

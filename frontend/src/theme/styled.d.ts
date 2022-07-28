import 'styled-components';

declare module 'styled-components' {
  export interface DefaultTheme {
    colors: {
      text: string;
      textSecondary: string;
      textDisabled: string;
      red: string;
      green: string;
      orange: string;
    };
    fontFamily: {
      poppins: string;
    };
    fontSize: {
      heading: string;
      big: string;
      medium: string;
      small: string;
    };
    fontWeight: {
      bold: number;
      regular: number;
    };
  }
}

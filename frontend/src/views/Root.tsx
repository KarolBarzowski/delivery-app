import { Routes, Route } from 'react-router-dom';
import { ThemeProvider } from 'styled-components';
import { theme } from 'theme/theme';
import { GlobalStyle } from 'theme/GlobalStyle';
import Home from 'views/Home';
import NotFound from 'views/NotFound';

function Root() {
  return (
    <ThemeProvider theme={theme}>
      <GlobalStyle />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="*" element={<NotFound />} />
      </Routes>
    </ThemeProvider>
  );
}

export default Root;

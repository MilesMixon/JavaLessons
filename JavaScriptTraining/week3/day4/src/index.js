import React from 'react';
import ReactDOM from 'react-dom/client';
import { Provider } from 'react-redux';
import { I18nextProvider } from 'react-i18next';
import i18n from './utils/i18n';
import './index.css';
import App from './App';
import store from './store';
import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <> {/* This is a React Fragment. React components can only return one item, fragments bundle multiple into one item */} 
  {/* This is a JSX comment */}
  {/* Provider is the Redux store, placing it here gives my entire application access to it */}
    <Provider store={store}>
      <I18nextProvider i18n={i18n}>
        <App />
      </I18nextProvider>
    </Provider>
  </>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();

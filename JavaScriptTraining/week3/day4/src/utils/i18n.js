import i18n from 'i18next';
import { initReactI18next } from 'react-i18next';

i18n.use(initReactI18next).init({
    resources: {
        en: {
            translation: {
                "Greeting": "Hello! This is my app!",
                "English": "English",
                "German": "German"
            }
        },
        de: {
            translation: {
                "Greeting": "Hallo! Das ist meine app!",
                "English": "Englisch",
                "German": "Deutsch"
            }
        }
    },
    fallbackLng: "en"
});

export default i18n;
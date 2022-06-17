import { useTranslation } from "react-i18next";

export const Translations = () => {
    const { t, i18n } = useTranslation();

    const changeLanguage = lang => {
        i18n.changeLanguage(lang);
    }
    
    return (
        <>
            <h1>{t('Greeting')}</h1>
            <button onClick={() => changeLanguage('en')}>{t('English')}</button>
            <button onClick={() => changeLanguage('de')}>{t('German')}</button>
        </>
    );
}
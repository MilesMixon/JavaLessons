export const Article = ({title, author, datePublished=new Date(), children}) => {
    /**
     * title
     * author
     * content
     * timestamp/date published
     */

    return (
        <article>
            <h2>{title}</h2>
            <h3>Author: {author}</h3>
            {children}
            <h4>Publish Date: {datePublished.toString()}</h4>
        </article>
    );
}
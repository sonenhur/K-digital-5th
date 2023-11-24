import style from './FrontEnd.module.css';
// rfce 단축어 쓰면 기본 틀 바로 완성!!

function FrontArticle({ title, href, text }) {
    return (
        <article className={style.divArticle} id="divArticle">
            <h2>{title}</h2>
            <div>
                <div className={style.divimg}>
                    <img src={href} alt={title} />
                </div>
                <p>
                    {text}
                </p>
            </div>
        </article>
    )
}

export default FrontArticle
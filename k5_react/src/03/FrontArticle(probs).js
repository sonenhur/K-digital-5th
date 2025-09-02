// rfce 단축어 쓰면 기본 틀 바로 완성!!

function FrontArticle(probs) {
    return (
        <article id="divHtml">
            <h3>{probs.title}</h3>
            <div>
                <div class="divimg">
                    <img src={probs.href} alt={probs.title} />
                </div>
                <p>
                    {probs.text}
                </p>
            </div>
        </article>
    )
}

export default FrontArticle
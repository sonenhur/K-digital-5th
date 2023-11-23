document.addEventListener("DOMContentLoaded", () => {
    // const sps = document.querySelectorAll(".sp");
    // console.log(sps[0])
    // console.log(sps[1])
    // console.log(sps[2])
    const sp0 = document.querySelector("#sp0")
    const sp1 = document.querySelector("#sp1")
    const sp2 = document.querySelector("#sp2")
    let n = 0;
    sp0.innerHTML = 0;
    console.log(sp0)
    console.log(sp1)
    console.log(sp2)

    sp1.addEventListener("click", () => {
        console.log(sp1.innerHTML)
        n = n + 1
        sp0.innerHTML = n;
    })
    sp2.addEventListener("click", () => {
        console.log(sp2.innerHTML)
        n = n - 1
        if (n < 0) n = 0;
        sp0.innerHTML = n;
    })

});
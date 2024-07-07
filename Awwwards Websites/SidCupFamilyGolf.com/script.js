/* This code snippet is using the GSAP (GreenSock Animation Platform) library to animate the element
with the id "nav". Here's a breakdown of what it's doing: */

var cursor = document.querySelector("#cursor");
var cursorBlur = document.querySelector("#cursor-blur");
document.addEventListener("mousemove",function(dets){
    cursor.style.top = dets.y-8 + "px";
    cursor.style.left = dets.x-10 + "px";
    cursorBlur.style.top = dets.y - 200 + "px";
    cursorBlur.style.left = dets.x - 200 + "px";

})


gsap.to("#nav",{
    backgroundColor: "#000",
    height: "120px",
    duration: 0.5,
    scrollTrigger: {
        trigger:"#nav",
        scroller:"body",
        // markers:true,
        start: "top -10%",
        end: "top -20%",
        scrub: 0.9
    }
})

gsap.to("#main",{
    backgroundColor : "#000",
    scrollTrigger: {
        trigger : "#main",
        scroller: "body",
        markers: true,
        start: "top -25%",
        end: "top -70%",
        scrub: 0.9
    }
})
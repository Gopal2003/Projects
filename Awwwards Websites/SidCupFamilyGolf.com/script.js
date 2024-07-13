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

var h4all = document.querySelectorAll("#nav h4");

h4all.forEach(function(elem){
        elem.addEventListener("mouseenter",function(){
            cursor.style.scale = "3";
            cursor.style.border = "1px solid #fff";
            cursor.style.backgroundColor = "transparent";
            elem.style.color = "black";
            cursor.style.transition = "all ease-in-out 0.2s";
        })

        elem.addEventListener("mouseleave",function(){
            cursor.style.scale = "1";
            cursor.style.border = "1px solid #95c11e";
            cursor.style.backgroundColor = "#95c11e";
            elem.style.color = "white";
            cursor.style.transition = "none";
            
        })
})

gsap.from("#about-us img,#about-us-in",{
    y:90,
    opacity:0,
    duration:1,
    scrollTrigger: {
        trigger: "#about-us",
        stagger:0.4,
        scroller: "body",
        start: "top 60%",
        end: "top 55%",
        scrub: 0.9
    }
})

// gsap.from(".card",{
//     scale:0.8,
//     opacity:0,
//     duration:0.5,
//     scrollTrigger: {
//         trigger: ".card",
//         // stagger:0.4,
//         scroller: "body",
//         start: "top 70%",
//         end: "top 65%",
//         scrub: 2
//     }
// })
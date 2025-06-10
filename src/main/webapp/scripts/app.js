// Swiper
var swiper2 = new Swiper(".content_img", {
    spaceBetween: 30,
    centeredSlides: true,
    autoplay: {
        delay: 5000,
        disableOnInteraction: false,
    },
    pagination: {
        el: ".swiper-pagination",
        clickable: true,
    },
    navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
    },
});

// Swiper
var swiper1= new Swiper(".wrapper__fsale-product", {
    spaceBetween: 20,
    loop: true,
    pagination: {
        el: ".swiper-pagination",
        clickable: true,
    },
    navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
    },
    centeredSlides: true,
    breakpoints:{
        0: {
            slidesPerView: 2
        },
        568: {
            slidesPerView: 3
        },
        768: {
            slidesPerView: 4
        },
        968: {
            slidesPerView: 5
        }
    }
});

// Swiper
var swiper5 = new Swiper(".wrapper__category-box", {
    spaceBetween: -20,
    centeredSlides: true,
    autoplay: {
        delay: 90000,
        disableOnInteraction: false,
    },
    pagination: {
        el: ".swiper-pagination",
        clickable: true,
    },
    navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
    },
});
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập tài khoản  - Mua sắm Online | Shopee Việt Nam</title>
    <link rel="icon" href="./assets/img/logoshopee-icon.png">
    <link rel="stylesheet" href="./assets/css/base.css">
    <link rel="stylesheet" href="./assets/css/main.css">
    <link rel="stylesheet" href="./assets/css/grid.css">
    <link rel="stylesheet" href="./assets/css/login.css">
    <link rel="stylesheet" href="./assets/css/responsive.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap&subset=vietnamese"
        rel="stylesheet">
    <link rel="stylesheet" href="./assets/fonts/fontawesome-free-6.2.1-web/css/all.min.css">
</head>
<body>
    <div class="main-login">
        <div class="container">
            <div class="auth-form">
                <div class="auth-form__container">
                    <div class="auth-form__header">
                        <a href="homeController">
                            <i class="fa-solid fa-arrow-left"></i>
                        </a>
                        <h3 class="auth-form__heading">Đăng nhập</h3>
                        <span class="auth-form__switch-btn">Đăng nhập với mã <br>QR</span>
                        <i class="fa-regular fa-circle-question"></i>
                    </div>
                    
                     <svg class="header__logo-img-login" viewBox="0 0 54 61">
                        <g fill-rule="evenodd">
                            <path fill="rgb(238, 77, 45)"
                                d="M35.67,44.95 C35.34,47.70 33.67,49.91 31.09,51.01 C29.65,51.63 27.72,51.96 26.19,51.85 C23.81,51.76 21.57,51.18 19.50,50.12 C18.77,49.74 17.67,48.99 16.82,48.28 C16.61,48.10 16.58,47.99 16.73,47.78 C16.80,47.67 16.94,47.46 17.25,47.01 C17.71,46.34 17.76,46.26 17.81,46.18 C17.96,45.96 18.19,45.94 18.42,46.12 C18.45,46.14 18.45,46.14 18.47,46.16 C18.50,46.19 18.50,46.19 18.59,46.26 C18.68,46.33 18.74,46.37 18.76,46.39 C20.99,48.13 23.58,49.13 26.20,49.24 C29.84,49.19 32.46,47.55 32.93,45.03 C33.44,42.27 31.27,39.88 27.02,38.54 C25.69,38.13 22.33,36.78 21.71,36.42 C18.80,34.71 17.44,32.47 17.64,29.71 C17.93,25.88 21.49,23.03 25.98,23.01 C27.98,23.01 29.99,23.42 31.91,24.23 C32.60,24.52 33.81,25.18 34.23,25.50 C34.47,25.68 34.52,25.88 34.38,26.11 C34.31,26.24 34.18,26.44 33.91,26.87 L33.91,26.87 C33.55,27.44 33.54,27.46 33.46,27.59 C33.32,27.80 33.15,27.82 32.90,27.66 C30.84,26.28 28.55,25.58 26.04,25.53 C22.91,25.59 20.57,27.45 20.42,29.99 C20.38,32.28 22.09,33.95 25.80,35.22 C33.33,37.64 36.21,40.48 35.67,44.95 M26.37,5.43 C31.27,5.43 35.27,10.08 35.46,15.90 L17.29,15.90 C17.47,10.08 21.47,5.43 26.37,5.43 M51.74,17.00 C51.74,16.39 51.26,15.90 50.66,15.90 L50.64,15.90 L38.88,15.90 C38.59,8.21 33.10,2.08 26.37,2.08 C19.64,2.08 14.16,8.21 13.87,15.90 L2.07,15.90 C1.48,15.91 1.01,16.40 1.01,17.00 C1.01,17.03 1.01,17.05 1.01,17.08 L1.00,17.08 L2.68,54.14 C2.68,54.25 2.69,54.35 2.69,54.46 C2.69,54.48 2.70,54.50 2.70,54.53 L2.70,54.60 L2.71,54.61 C2.96,57.19 4.83,59.26 7.38,59.36 L7.38,59.37 L44.80,59.37 C44.81,59.37 44.83,59.37 44.85,59.37 C44.87,59.37 44.88,59.37 44.90,59.37 L44.98,59.37 L44.98,59.36 C47.57,59.29 49.67,57.19 49.89,54.58 L49.89,54.58 L49.90,54.54 C49.90,54.51 49.90,54.49 49.90,54.46 C49.90,54.39 49.91,54.33 49.91,54.26 L51.74,17.05 L51.74,17.05 C51.74,17.04 51.74,17.02 51.74,17.00">
                            </path>
                        </g>
                    </svg>    				                                     
                    <form action="login" method="post" class="auth-form__form">
		               <span style="font-size: 1.2rem; color: #EE4D2D;">
						<%
							if (request.getParameter("war") != null)
								out.print(request.getParameter("war"));
						%>
						</span>
                        <div class="auth-form__group">
							<i class="fa-regular fa-user"></i>
                            <input name="email" type="text" class="auth-form__input" placeholder="Email/Số diện thoại/Tên đăng nhập">
                        </div>
                        <div class="auth-form__group">
                        	<i class="fa-solid fa-lock"></i>
                            <input name="password" type="password" class="auth-form__input" placeholder="Mật khẩu">
                        </div>
	                    <div class="auth-form__controls">
	                          <button class="btn btn--primary">ĐĂNG NHẬP</button>
	                    </div>
                    </form>
    							
                    <div class="auth-form__aside">
                        <div class="auth-form__help">
                            <a href="" class="auth-form__help-link auth-form__help-forgot">Quên mật khẩu</a>
                            <a href="" class="auth-form__help-link">Đăng nhập với SMS</a>
                        </div>
                    </div>
                </div>
                <div class="auth-line-or">
                    <span class="left-line">Hoặc</span>
                    <span class="right-line"></span>
                </div>
                <div class="auth-form__socials">
                    <a href="" class="auth-form__socials--facebook">
                        <i class="fa-brands fa-facebook"></i>
                        <span class="auth-form__socials-title">
                            Facebook
                        </span>
                    </a>
                    <a href="" class="auth-form__socials--google">
                        <i class="fa-brands fa-google"></i>
                        <span class="auth-form__socials-title">
                           Google
                        </span>
                    </a>
                </div>
                <div class="auth-footer">
                    <span>Bạn mới biết đến Shopee?</span>
                    <a href="./register">
                        <span>Đăng ký</span>
                    </a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
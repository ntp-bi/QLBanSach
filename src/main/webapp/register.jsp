<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng ký tài khoản  - Mua sắm Online | Shopee Việt Nam</title>
    <link rel="icon" href="./assets/img/logoshopee-icon.png">
    <link rel="stylesheet" href="./assets/css/base.css">
    <link rel="stylesheet" href="./assets/css/main.css">
    <link rel="stylesheet" href="./assets/css/grid.css">
    <link rel="stylesheet" href="./assets/css/login.css">
    <link rel="stylesheet" href="./assets/css/register.css">
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
                <form action="register" method="post" class="auth-form__container auth-form__container-mobile">
                    <div class="auth-form__header auth-form__header-mobile">
                    	<a href="">
                            <i class="fa-solid fa-arrow-left"></i>
                        </a>
                        <h3 class="auth-form__heading">Đăng ký</h3>  
                         <i class="fa-regular fa-circle-question"></i>                    
                    </div>
    				<span style="font-size: 1.2rem; color: #EE4D2D;">	
    					<%
						if (request.getParameter("war") != null)
							out.print(request.getParameter("war"));
						%>	
					</span>
                    <div class="auth-form__form">
                        <div class="auth-form__group-res">
                            <input name="email" type="text" class="auth-form__input" placeholder="Email/Số diện thoại/Tên đăng nhập">
                        </div>
                        <div class="auth-form__group-res">
                            <input name="username" type="text" class="auth-form__input" placeholder="Họ và tên">
                        </div>
                        <div class="auth-form__group-res">
                            <input name="password" type="password" class="auth-form__input" placeholder="Mật khẩu">
                        </div>
                    </div>
    
                    <div class="auth-form__controls">
                        <button class="btn btn--primary">ĐĂNG KÝ</button>                       
                    </div>                  
                </form>
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
                <div class="auth-policy">
                    <span>Bằng việc đăng ký, bạn đã đồng ý với Shopee về<br></span>
                    <a href="#">Điều khoản dịch vụ</a> &
                    <a href="#">Chính sách bảo mật</a>
                </div>
                <div class="auth-footer">
                    <span>Bạn đã có tài khoản?</span>
                    <a href="./login">
                        <span>Đăng nhập</span>
                    </a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
# DATABASE QLSach
USE [QLSach]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 12/26/2023 2:28:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[MaChiTietHD] [bigint] IDENTITY(1,1) NOT NULL,
	[MaSach] [nvarchar](50) NOT NULL,
	[SoLuongMua] [int] NOT NULL,
	[MaHoaDon] [bigint] NOT NULL,
	[damua] [bit] NULL,
 CONSTRAINT [PK_ChiTietHoaDon] PRIMARY KEY CLUSTERED 
(
	[MaChiTietHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DangNhap]    Script Date: 12/26/2023 2:28:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DangNhap](
	[TenDangNhap] [nvarchar](50) NOT NULL,
	[MatKhau] [nvarchar](50) NULL,
	[Quyen] [bit] NOT NULL,
 CONSTRAINT [PK_DangNhap] PRIMARY KEY CLUSTERED 
(
	[TenDangNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[hoadon]    Script Date: 12/26/2023 2:28:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[hoadon](
	[MaHoaDon] [bigint] IDENTITY(1,1) NOT NULL,
	[makh] [bigint] NULL,
	[NgayMua] [datetime] NOT NULL,
	[damua] [bit] NULL,
 CONSTRAINT [PK_hoadon] PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 12/26/2023 2:28:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[makh] [bigint] IDENTITY(1,1) NOT NULL,
	[hoten] [nvarchar](50) NULL,
	[diachi] [nvarchar](50) NULL,
	[sodt] [nvarchar](50) NULL,
	[email] [nvarchar](50) NULL,
	[tendn] [nvarchar](50) NULL,
	[pass] [nvarchar](50) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[makh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[loai]    Script Date: 12/26/2023 2:28:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[loai](
	[maloai] [nvarchar](50) NOT NULL,
	[tenloai] [nvarchar](50) NULL,
 CONSTRAINT [PK_loai] PRIMARY KEY CLUSTERED 
(
	[maloai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[sach]    Script Date: 12/26/2023 2:28:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sach](
	[masach] [nvarchar](50) NOT NULL,
	[tensach] [nvarchar](50) NULL,
	[soluong] [bigint] NULL,
	[gia] [bigint] NULL,
	[maloai] [nvarchar](50) NULL,
	[sotap] [nvarchar](50) NULL,
	[anh] [nvarchar](50) NULL,
	[NgayNhap] [datetime] NULL,
	[tacgia] [nvarchar](50) NULL,
 CONSTRAINT [PK_sach] PRIMARY KEY CLUSTERED 
(
	[masach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  View [dbo].[abc]    Script Date: 12/26/2023 2:28:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[abc]
AS
SELECT     dbo.sach.tensach, dbo.loai.tenloai, dbo.ChiTietHoaDon.SoLuongMua
FROM         dbo.ChiTietHoaDon INNER JOIN
                      dbo.sach ON dbo.ChiTietHoaDon.MaSach = dbo.sach.masach INNER JOIN
                      dbo.loai ON dbo.sach.maloai = dbo.loai.maloai

GO
/****** Object:  View [dbo].[HtSach]    Script Date: 12/26/2023 2:28:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[HtSach]
AS
SELECT     dbo.sach.maloai, dbo.loai.tenloai, dbo.sach.masach, dbo.sach.tensach, dbo.sach.tacgia, dbo.sach.gia
FROM         dbo.loai INNER JOIN
                      dbo.sach ON dbo.loai.maloai = dbo.sach.maloai

GO
/****** Object:  View [dbo].[rrr]    Script Date: 12/26/2023 2:28:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[rrr]
AS
SELECT     dbo.loai.tenloai, dbo.sach.tensach, dbo.sach.gia, dbo.ChiTietHoaDon.SoLuongMua
FROM         dbo.ChiTietHoaDon INNER JOIN
                      dbo.hoadon ON dbo.ChiTietHoaDon.MaHoaDon = dbo.hoadon.MaHoaDon INNER JOIN
                      dbo.sach ON dbo.ChiTietHoaDon.MaSach = dbo.sach.masach INNER JOIN
                      dbo.loai ON dbo.sach.maloai = dbo.loai.maloai

GO
/****** Object:  View [dbo].[tk]    Script Date: 12/26/2023 2:28:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[tk]
AS
SELECT     dbo.loai.tenloai, SUM(dbo.sach.soluong) AS TongSoLuong, AVG(dbo.sach.gia) AS TBCGia, COUNT(dbo.sach.tensach) AS SoSach
FROM         dbo.loai INNER JOIN
                      dbo.sach ON dbo.loai.maloai = dbo.sach.maloai
GROUP BY dbo.loai.tenloai

GO
/****** Object:  View [dbo].[Vabcd]    Script Date: 12/26/2023 2:28:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[Vabcd]
AS
SELECT     dbo.ChiTietHoaDon.MaSach, dbo.ChiTietHoaDon.SoLuongMua, dbo.hoadon.NgayMua, dbo.loai.tenloai, dbo.sach.soluong
FROM         dbo.ChiTietHoaDon INNER JOIN
                      dbo.hoadon ON dbo.ChiTietHoaDon.MaHoaDon = dbo.hoadon.MaHoaDon INNER JOIN
                      dbo.sach ON dbo.ChiTietHoaDon.MaSach = dbo.sach.masach INNER JOIN
                      dbo.loai ON dbo.sach.maloai = dbo.loai.maloai

GO
/****** Object:  View [dbo].[VAdminXacNhan]    Script Date: 12/26/2023 2:28:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[VAdminXacNhan]
AS
SELECT dbo.ChiTietHoaDon.MaChiTietHD, dbo.KhachHang.hoten, dbo.sach.tensach, dbo.sach.gia, dbo.ChiTietHoaDon.SoLuongMua, dbo.ChiTietHoaDon.SoLuongMua * dbo.sach.gia AS thanhtien, dbo.hoadon.damua
FROM   dbo.ChiTietHoaDon INNER JOIN
             dbo.hoadon ON dbo.ChiTietHoaDon.MaHoaDon = dbo.hoadon.MaHoaDon INNER JOIN
             dbo.KhachHang ON dbo.hoadon.makh = dbo.KhachHang.makh INNER JOIN
             dbo.sach ON dbo.ChiTietHoaDon.MaSach = dbo.sach.masach
WHERE (dbo.hoadon.damua = 0)

GO
/****** Object:  View [dbo].[Vhoadon]    Script Date: 12/26/2023 2:28:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[Vhoadon]
AS
SELECT     dbo.sach.masach, dbo.sach.tensach, dbo.sach.gia, dbo.ChiTietHoaDon.SoLuongMua
FROM         dbo.sach INNER JOIN
                      dbo.ChiTietHoaDon ON dbo.sach.masach = dbo.ChiTietHoaDon.MaSach INNER JOIN
                      dbo.hoadon ON dbo.ChiTietHoaDon.MaHoaDon = dbo.hoadon.MaHoaDon
WHERE     (dbo.hoadon.damua = 0)

GO
/****** Object:  View [dbo].[Vlichsu]    Script Date: 12/26/2023 2:28:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[Vlichsu]
AS
SELECT dbo.sach.soluong, dbo.sach.gia, dbo.ChiTietHoaDon.SoLuongMua * dbo.sach.gia AS thanhtien, dbo.ChiTietHoaDon.MaSach, dbo.hoadon.makh, dbo.ChiTietHoaDon.SoLuongMua, dbo.hoadon.damua, dbo.sach.anh, dbo.sach.tensach
FROM   dbo.ChiTietHoaDon INNER JOIN
             dbo.hoadon ON dbo.ChiTietHoaDon.MaHoaDon = dbo.hoadon.MaHoaDon INNER JOIN
             dbo.KhachHang ON dbo.hoadon.makh = dbo.KhachHang.makh INNER JOIN
             dbo.sach ON dbo.ChiTietHoaDon.MaSach = dbo.sach.masach

GO
/****** Object:  View [dbo].[Vqq]    Script Date: 12/26/2023 2:28:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[Vqq]
AS
SELECT     dbo.loai.tenloai, dbo.sach.tensach, dbo.sach.tacgia, dbo.ChiTietHoaDon.SoLuongMua
FROM         dbo.ChiTietHoaDon INNER JOIN
                      dbo.hoadon ON dbo.ChiTietHoaDon.MaHoaDon = dbo.hoadon.MaHoaDon INNER JOIN
                      dbo.sach ON dbo.ChiTietHoaDon.MaSach = dbo.sach.masach INNER JOIN
                      dbo.loai ON dbo.sach.maloai = dbo.loai.maloai

GO
/****** Object:  View [dbo].[VTamBay]    Script Date: 12/26/2023 2:28:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[VTamBay]
AS
SELECT     dbo.ChiTietHoaDon.MaSach, dbo.ChiTietHoaDon.SoLuongMua, dbo.hoadon.makh, dbo.hoadon.NgayMua, dbo.KhachHang.diachi, dbo.KhachHang.hoten, 
                      dbo.sach.tensach, dbo.sach.tacgia
FROM         dbo.ChiTietHoaDon INNER JOIN
                      dbo.hoadon ON dbo.ChiTietHoaDon.MaHoaDon = dbo.hoadon.MaHoaDon INNER JOIN
                      dbo.KhachHang ON dbo.hoadon.makh = dbo.KhachHang.Makh INNER JOIN
                      dbo.sach ON dbo.ChiTietHoaDon.MaSach = dbo.sach.masach INNER JOIN
                      dbo.loai ON dbo.sach.maloai = dbo.loai.maloai

GO
/****** Object:  View [dbo].[Vtest]    Script Date: 12/26/2023 2:28:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[Vtest]
AS
SELECT     dbo.sach.tensach, dbo.loai.tenloai, dbo.ChiTietHoaDon.SoLuongMua, dbo.sach.gia, dbo.hoadon.NgayMua, dbo.KhachHang.hoten
FROM         dbo.ChiTietHoaDon INNER JOIN
                      dbo.hoadon ON dbo.ChiTietHoaDon.MaHoaDon = dbo.hoadon.MaHoaDon INNER JOIN
                      dbo.KhachHang ON dbo.hoadon.makh = dbo.KhachHang.makh INNER JOIN
                      dbo.sach ON dbo.ChiTietHoaDon.MaSach = dbo.sach.masach INNER JOIN
                      dbo.loai ON dbo.sach.maloai = dbo.loai.maloai

GO
/****** Object:  View [dbo].[VTK]    Script Date: 12/26/2023 2:28:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[VTK]
AS
SELECT     dbo.loai.tenloai, COUNT(dbo.sach.tacgia) AS SoSach, SUM(dbo.sach.soluong) AS TongSl, AVG(dbo.sach.gia) AS TbcGia
FROM         dbo.loai INNER JOIN
                      dbo.sach ON dbo.loai.maloai = dbo.sach.maloai
GROUP BY dbo.loai.tenloai

GO
/****** Object:  View [dbo].[VTKabc]    Script Date: 12/26/2023 2:28:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[VTKabc]
AS
SELECT     dbo.loai.tenloai, SUM(dbo.sach.soluong) AS Tongkho, SUM(dbo.ChiTietHoaDon.SoLuongMua) AS Tongmua, COUNT(dbo.KhachHang.hoten) AS SoKH
FROM         dbo.loai INNER JOIN
                      dbo.sach ON dbo.loai.maloai = dbo.sach.maloai INNER JOIN
                      dbo.ChiTietHoaDon ON dbo.sach.masach = dbo.ChiTietHoaDon.MaSach INNER JOIN
                      dbo.hoadon ON dbo.ChiTietHoaDon.MaHoaDon = dbo.hoadon.MaHoaDon INNER JOIN
                      dbo.KhachHang ON dbo.hoadon.makh = dbo.KhachHang.makh
GROUP BY dbo.loai.tenloai

GO
/****** Object:  View [dbo].[Vtktest]    Script Date: 12/26/2023 2:28:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[Vtktest]
AS
SELECT     dbo.loai.tenloai, SUM(dbo.sach.soluong) AS Tongsl, SUM(dbo.ChiTietHoaDon.SoLuongMua) AS Tongslmua, COUNT(dbo.KhachHang.hoten) AS SoKhach
FROM         dbo.hoadon INNER JOIN
                      dbo.ChiTietHoaDon ON dbo.hoadon.MaHoaDon = dbo.ChiTietHoaDon.MaHoaDon INNER JOIN
                      dbo.sach INNER JOIN
                      dbo.loai ON dbo.sach.maloai = dbo.loai.maloai ON dbo.ChiTietHoaDon.MaSach = dbo.sach.masach INNER JOIN
                      dbo.KhachHang ON dbo.hoadon.makh = dbo.KhachHang.makh
GROUP BY dbo.loai.tenloai

GO
SET IDENTITY_INSERT [dbo].[ChiTietHoaDon] ON 

INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHD], [MaSach], [SoLuongMua], [MaHoaDon], [damua]) VALUES (169, N'b1', 1, 186, 0)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHD], [MaSach], [SoLuongMua], [MaHoaDon], [damua]) VALUES (170, N'c11', 1, 187, 0)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHD], [MaSach], [SoLuongMua], [MaHoaDon], [damua]) VALUES (171, N'd6', 1, 188, 0)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHD], [MaSach], [SoLuongMua], [MaHoaDon], [damua]) VALUES (172, N'd3', 1, 189, 0)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHD], [MaSach], [SoLuongMua], [MaHoaDon], [damua]) VALUES (173, N'b1', 1, 190, 0)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHD], [MaSach], [SoLuongMua], [MaHoaDon], [damua]) VALUES (174, N'b1', 1, 191, 0)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHD], [MaSach], [SoLuongMua], [MaHoaDon], [damua]) VALUES (175, N'b18', 1, 192, 0)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHD], [MaSach], [SoLuongMua], [MaHoaDon], [damua]) VALUES (176, N'b20', 1, 193, 0)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHD], [MaSach], [SoLuongMua], [MaHoaDon], [damua]) VALUES (177, N'b16', 1, 194, 0)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHD], [MaSach], [SoLuongMua], [MaHoaDon], [damua]) VALUES (178, N'b11', 1, 195, 0)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHD], [MaSach], [SoLuongMua], [MaHoaDon], [damua]) VALUES (179, N'b17', 1, 196, 0)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHD], [MaSach], [SoLuongMua], [MaHoaDon], [damua]) VALUES (180, N'b11', 1, 197, 0)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHD], [MaSach], [SoLuongMua], [MaHoaDon], [damua]) VALUES (181, N'b22', 1, 198, 0)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHD], [MaSach], [SoLuongMua], [MaHoaDon], [damua]) VALUES (182, N'b1', 1, 199, 0)
INSERT [dbo].[ChiTietHoaDon] ([MaChiTietHD], [MaSach], [SoLuongMua], [MaHoaDon], [damua]) VALUES (183, N'b11', 1, 200, 0)
SET IDENTITY_INSERT [dbo].[ChiTietHoaDon] OFF
INSERT [dbo].[DangNhap] ([TenDangNhap], [MatKhau], [Quyen]) VALUES (N'abc', N'123', 0)
INSERT [dbo].[DangNhap] ([TenDangNhap], [MatKhau], [Quyen]) VALUES (N'dencan', N'111', 1)
INSERT [dbo].[DangNhap] ([TenDangNhap], [MatKhau], [Quyen]) VALUES (N'nhha', N'2ezur0ziU1o=', 1)
INSERT [dbo].[DangNhap] ([TenDangNhap], [MatKhau], [Quyen]) VALUES (N'nhha76', N'J2A461dUG8UKL/8XBhus3g==', 1)
SET IDENTITY_INSERT [dbo].[hoadon] ON 

INSERT [dbo].[hoadon] ([MaHoaDon], [makh], [NgayMua], [damua]) VALUES (186, 53, CAST(N'2023-12-24 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[hoadon] ([MaHoaDon], [makh], [NgayMua], [damua]) VALUES (187, 53, CAST(N'2023-12-24 00:00:00.000' AS DateTime), 0)
INSERT [dbo].[hoadon] ([MaHoaDon], [makh], [NgayMua], [damua]) VALUES (188, 53, CAST(N'2023-12-24 00:00:00.000' AS DateTime), 0)
INSERT [dbo].[hoadon] ([MaHoaDon], [makh], [NgayMua], [damua]) VALUES (189, 53, CAST(N'2023-12-24 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[hoadon] ([MaHoaDon], [makh], [NgayMua], [damua]) VALUES (190, 53, CAST(N'2023-12-24 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[hoadon] ([MaHoaDon], [makh], [NgayMua], [damua]) VALUES (191, 53, CAST(N'2023-12-24 00:00:00.000' AS DateTime), 0)
INSERT [dbo].[hoadon] ([MaHoaDon], [makh], [NgayMua], [damua]) VALUES (192, 53, CAST(N'2023-12-24 00:00:00.000' AS DateTime), 0)
INSERT [dbo].[hoadon] ([MaHoaDon], [makh], [NgayMua], [damua]) VALUES (193, 53, CAST(N'2023-12-24 00:00:00.000' AS DateTime), 0)
INSERT [dbo].[hoadon] ([MaHoaDon], [makh], [NgayMua], [damua]) VALUES (194, 53, CAST(N'2023-12-25 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[hoadon] ([MaHoaDon], [makh], [NgayMua], [damua]) VALUES (195, 53, CAST(N'2023-12-25 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[hoadon] ([MaHoaDon], [makh], [NgayMua], [damua]) VALUES (196, 53, CAST(N'2023-12-25 00:00:00.000' AS DateTime), 0)
INSERT [dbo].[hoadon] ([MaHoaDon], [makh], [NgayMua], [damua]) VALUES (197, 53, CAST(N'2023-12-25 00:00:00.000' AS DateTime), 0)
INSERT [dbo].[hoadon] ([MaHoaDon], [makh], [NgayMua], [damua]) VALUES (198, 53, CAST(N'2023-12-25 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[hoadon] ([MaHoaDon], [makh], [NgayMua], [damua]) VALUES (199, 53, CAST(N'2023-12-25 00:00:00.000' AS DateTime), 1)
INSERT [dbo].[hoadon] ([MaHoaDon], [makh], [NgayMua], [damua]) VALUES (200, 53, CAST(N'2023-12-26 00:00:00.000' AS DateTime), 0)
SET IDENTITY_INSERT [dbo].[hoadon] OFF
SET IDENTITY_INSERT [dbo].[KhachHang] ON 

INSERT [dbo].[KhachHang] ([makh], [hoten], [diachi], [sodt], [email], [tendn], [pass]) VALUES (20, N'Nguyễn Khắc Chung', N'Huế', NULL, NULL, N'nkchung', N'123')
INSERT [dbo].[KhachHang] ([makh], [hoten], [diachi], [sodt], [email], [tendn], [pass]) VALUES (53, N'Nguyễn Tâm Phước', N'Thừa Thiên Huế', N'0342820213', N'phuocnt02@gmail.com', N'NTP', N'202cb962ac59075b964b07152d234b70')
INSERT [dbo].[KhachHang] ([makh], [hoten], [diachi], [sodt], [email], [tendn], [pass]) VALUES (55, N'Nguyễn Tâm Phước', NULL, NULL, NULL, N'bii', N'202cb962ac59075b964b07152d234b70')
INSERT [dbo].[KhachHang] ([makh], [hoten], [diachi], [sodt], [email], [tendn], [pass]) VALUES (60, N'Nguyễn Tâm Phước', NULL, NULL, NULL, N'abc', N'202cb962ac59075b964b07152d234b70')
INSERT [dbo].[KhachHang] ([makh], [hoten], [diachi], [sodt], [email], [tendn], [pass]) VALUES (63, N'Nguyễn Tâm Phước ', NULL, NULL, NULL, N'Admin', N'202cb962ac59075b964b07152d234b70')
INSERT [dbo].[KhachHang] ([makh], [hoten], [diachi], [sodt], [email], [tendn], [pass]) VALUES (65, N'', NULL, NULL, NULL, N'', N'd41d8cd98f00b204e9800998ecf8427e')
INSERT [dbo].[KhachHang] ([makh], [hoten], [diachi], [sodt], [email], [tendn], [pass]) VALUES (66, N'Nguyễn Tâm Phước', NULL, NULL, NULL, N'Bi', N'202cb962ac59075b964b07152d234b70')
SET IDENTITY_INSERT [dbo].[KhachHang] OFF
INSERT [dbo].[loai] ([maloai], [tenloai]) VALUES (N'Bi quyet cuoc song', N'Bí quyết cuộc sống')
INSERT [dbo].[loai] ([maloai], [tenloai]) VALUES (N'Chinh tri', N'Chính trị')
INSERT [dbo].[loai] ([maloai], [tenloai]) VALUES (N'Dia ly', N'Địa lý abc')
INSERT [dbo].[loai] ([maloai], [tenloai]) VALUES (N'Hoa hoc', N'Hoá học')
INSERT [dbo].[loai] ([maloai], [tenloai]) VALUES (N'Khoa hoc', N'Khoa học')
INSERT [dbo].[loai] ([maloai], [tenloai]) VALUES (N'Kinh te', N'Kinh tế')
INSERT [dbo].[loai] ([maloai], [tenloai]) VALUES (N'Lich su', N'Lịch Sử')
INSERT [dbo].[loai] ([maloai], [tenloai]) VALUES (N'Ngoai ngu', N'Ngoại ngữ')
INSERT [dbo].[loai] ([maloai], [tenloai]) VALUES (N'On thi CD-DH', N'Ôn thi CĐ-ĐH')
INSERT [dbo].[loai] ([maloai], [tenloai]) VALUES (N'Tam ly', N'Tâm lý')
INSERT [dbo].[loai] ([maloai], [tenloai]) VALUES (N'Tin', N'Tin Học')
INSERT [dbo].[loai] ([maloai], [tenloai]) VALUES (N'Toan', N'Toán Học')
INSERT [dbo].[loai] ([maloai], [tenloai]) VALUES (N'Van', N'Văn Học')
INSERT [dbo].[loai] ([maloai], [tenloai]) VALUES (N'Vat ly', N'Vật lý')
INSERT [dbo].[loai] ([maloai], [tenloai]) VALUES (N'Y hoc', N'Y học')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'b1', N'tyi', 124, 1123, N'Bi quyet cuoc song', N'1', N'image_sach/b1.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Anne Morrow Lindbergh')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'b11', N'Tìm lại chính mình', 18, 42000, N'Bi quyet cuoc song', N'1', N'image_sach/b11.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Marcia Grad')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'b12', N'Tìm lại giá trị cuộc sống', 40, 26000, N'Bi quyet cuoc song', N'1', N'image_sach/b12.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Mark V. Hansen, Jack Canfield')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'b14', N'Sứ mệnh yêu thương', 26, 40000, N'Bi quyet cuoc song', N'1', N'image_sach/b14.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Roger Cole')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'b16', N'Con sẽ làm được', 100, 23000, N'Bi quyet cuoc song', N'1', N'image_sach/b16.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Donna M.Gennett- Ph.D')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'b17', N'Đi tìm ý nghĩa cuộc sống', 50, 37000, N'Bi quyet cuoc song', N'1', N'image_sach/b17.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'ERNIE CARWILE')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'b18', N'Cảm ơn ký ức', 30, 45000, N'Bi quyet cuoc song', N'1', N'image_sach/b18.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'CeceliAhern')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'b19', N'Hạt Giống Tâm Hồn dành cho sinh viên hoc sinh', 20, 22000, N'Bi quyet cuoc song', N'2', N'image_sach/b19.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Jack Canield-Mark Victor Hansen')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'b2', N'Bí mật của may mắn', 10, 18000, N'Bi quyet cuoc song', N'1', N'image_sach/b2.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N' Tổng hợp thành phố Hồ Chí Minh')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'b20', N'Hạt Giống Tâm Hồn dành riêng cho phụ nữ', 30, 22000, N'Bi quyet cuoc song', N'2', N'image_sach/b20.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Jack Canield-Mark Victor Hansen')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'b21', N'Hạt Giống Tâm Hồn dành cho tuổi Teen', 36, 29000, N'Bi quyet cuoc song', N'1', N'image_sach/b21.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nhiều tác giả First News tổng hợp và thực hiện')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'b22', N'Làm thế nào để con chăm học', 50, 26000, N'Bi quyet cuoc song', N'1', N'image_sach/b22.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Lê Duyên Hải')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'b24', N'Những giá trị cuộc sống', 56, 27000, N'Bi quyet cuoc song', N'1', N'image_sach/b24.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Diane Tillman')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'b25', N'Quà tặng diệu kỳ', 30, 26000, N'Bi quyet cuoc song', N'1', N'image_sach/b25.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Mark V. Hansen, Jack Canfield')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'b3', N'Chấp cánh tuổi thơ', 15, 24000, N'Bi quyet cuoc song', N'1', N'image_sach/b3.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Tổng hợp TP Hồ Chí Minh')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'b4', N'Hạt giống yêu thương-Chicken Soup for the Soul 20', 20, 30000, N'Bi quyet cuoc song', N'1', N'image_sach/b4.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nhiều tác giả - Tổng hợp và thực hiện First News')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'b5', N'Gía trị cuộc sống', 30, 14000, N'Bi quyet cuoc song', N'1', N'image_sach/b5.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Tổng hợp thành phố Hồ Chí Minh')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'b6', N'Hãy yêu cuộc sống của bạn chọn', 25, 40000, N'Bi quyet cuoc song', N'1', N'image_sach/b6.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Tổng hợp TP Hồ Chí Minh')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'b7', N'Quà tặng cuộc sống', 30, 19000, N'Bi quyet cuoc song', N'1', N'image_sach/b7.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Dr.Bernie S.Siegel')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'b8', N'Quà tặng tinh thần dành cho phụ nữ', 10, 20000, N'Bi quyet cuoc song', N'1', N'image_sach/b8.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nhiều tác giả - Biên soạn: First News')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'c10', N'Triết học Phương Đông', 56, 23000, N'Chinh tri', N'1', N'image_sach/c10.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'M.T.STEPANLANTS')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'c11', N'Mắt bão - Những năm tháng của tôi tại CIA', 10, 144000, N'Chinh tri', N'1', N'image_sach/c11.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'George Tenet')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'c12', N'11Võ Văn Kiệt - Đổi mới, bản lĩnh và sáng tạo', 34, 55000, N'Chinh tri', N'1', N'image_sach/c12.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Võ Văn Kiệt')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'c2', N'Các trường phái triết học', 15, 110000, N'Chinh tri', N'1', N'image_sach/c2.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'David E Cooper')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'c3', N'Chủ nghĩa Mac-Lênin bàn về TN và công tác TN', 40, 14000, N'Chinh tri', N'1', N'image_sach/c3.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Phạm Đình Nghiệp')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'c5', N'Nhận diện chủ nghĩa tự do mới', 26, 16000, N'Chinh tri', N'1', N'image_sach/c5.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nguyễn Văn Thanh')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'c6', N'Tư tưởng HCM về dựng nước đi đôi với giữ nước', 10, 56000, N'Chinh tri', N'1', N'image_sach/c6.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Viện khoa học xã hội nhân văn quân sự')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'c7', N'Cuộc chiến ngầm-Bí sử nhà trắng 2006-2008', 5, 130000, N'Chinh tri', N'1', N'image_sach/c7.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Bob Woodward')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'c8', N'Tuyển tập danh tác triết học từ plato đến derrida', 3, 185000, N'Chinh tri', N'1', N'image_sach/c8.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Eorrest E.baird')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'c9', N'Những chuyên đề triết học', 40, 19000, N'Chinh tri', N'1', N'image_sach/c9.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nhà xuất bản-Khoa học xã hội')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'd1', N'Bản đồ địa lý thế giới', 30, 34000, N'Dia ly', N'1', N'image_sach/d1.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Phạm Cao Hoàn')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'd2', N'Địa lý hành chính Việt Nam', 10, 30000, N'Dia ly', N'1', N'image_sach/d2.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nguyễn Huy')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'd3', N'Ôn tập để học tốt địa lý 11', 40, 20000, N'Dia ly', N'2', N'image_sach/d3.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Phạm Thị Sen-Nguyễn Việt Hùng')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'd4', N'Đổi mới phương pháp dạy học và kiểm tra địa lý 10', 26, 27000, N'Dia ly', N'1', N'image_sach/d4.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nguyễn Hải Châu')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'd5', N'Atlat địa lý Việt Nam', 500, 19000, N'Dia ly', N'1', N'image_sach/d5.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'NXB Giáo dục')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'd6', N'Địa lý và bản đồ', 48, 3600, N'Dia ly', N'1', N'image_sach/d6.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Hồ Tiến Huân')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'd7', N'Địa lý kinh tế-Xã hội châu âu', 40, 25000, N'Dia ly', N'1', N'image_sach/d7.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Bùi Thị Hải Yến-Phạm Thị Ngọc Diệp')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'h1', N'Hoá học đại cương', 200, 36000, N'Hoa hoc', N'1', N'image_sach/h1.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'NXB khkt')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'h2', N'Hoá học 12 nâng cao', 330, 24000, N'Hoa hoc', N'1', N'image_sach/h2.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nguyễn Đức Nghĩa')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'h3', N'Hướng dẫn sử dụng hiệu quả hoá 12 nâng cao', 400, 36000, N'Hoa hoc', N'1', N'image_sach/h3.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Lê Thanh Hải')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'h4', N'Hoá học 11 nâng cao', 50, 31000, N'Hoa hoc', N'1', N'image_sach/h4.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nguyễn Minh An')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'h5', N'Hoá học 12', 40, 23000, N'Hoa hoc', N'1', N'image_sach/h5.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Trần Xuân Bắc')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'h6', N'Hoá học đại cương 1', 600, 50000, N'Hoa hoc', N'2', N'image_sach/h6.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nguyễn Đức Vận')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'h7', N'Hoá học đại cương 2', 700, 50000, N'Hoa hoc', N'2', N'image_sach/h7.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nguyễn Đức Vận')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'h8', N'Câu hỏi lý thuyết và bài tập trắc nghiệm hoá học', 56, 67000, N'Hoa hoc', N'1', N'image_sach/h8.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Lê Thanh Xuân')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'k1', N'Từ điển tường giải kinh tế thị trường xã hội', 7, 165000, N'Kinh te', N'1', N'image_sach/k1.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Rolf H. Hasse-Hermann Schneider-Klaus Weigelt')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'k10', N'Nguồn gốc của khủng hoảng tài chính', 50, 55000, N'Kinh te', N'1', N'image_sach/k10.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'George Cooper')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'k11', N'Vượt qua khủng hoảng kinh tế', 48, 39000, N'Kinh te', N'1', N'image_sach/k11.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nguyễn Sơn')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'k12', N'Chiến lược cạnh tranh mới', 36, 50000, N'Kinh te', N'1', N'image_sach/k12.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Tạ Ngọc Ái')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'k2', N'Từ điển thuật ngữ thị trường chứng khoán', 20, 65000, N'Kinh te', N'1', N'image_sach/k2.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'First News')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'k3', N'Quản trị tài chính', 5, 285000, N'Kinh te', N'1', N'image_sach/k3.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Eugene F Brigham -Joel F Houston')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'k4', N'Từ điển kinh tế thương mại Anh', 10, 188000, N'Kinh te', N'1', N'image_sach/k4.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Trần Văn Chánh')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'k5', N'Bí quyết kinh doanh', 20, 68000, N'Kinh te', N'1', N'image_sach/k5.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Tạ Ngọc Ái')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'k6', N'Thuật lãnh đạo', 30, 40000, N'Kinh te', N'1', N'image_sach/k6.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'NXB Từ điển bách khoa')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'k7', N'Chiến lược thương hiệu Châu Á', 45, 69000, N'Kinh te', N'1', N'image_sach/k7.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Martin Roll')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'k8', N'Để thành công chứng khoán', 12, 60000, N'Kinh te', N'1', N'image_sach/k8.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'NXB trẻ')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'k9', N'Từ điển thuật ngữ kinh tế tài chính', 29, 63000, N'Kinh te', N'1', N'image_sach/k9.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Bernrd & Colli')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'khoa1', N'Hồ Sơ Nội Bộ', 36, 65000, N'Khoa hoc', N'1', N'image_sach/khoa1.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Lưu Bình')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'khoa11', N'Sách của bạn tôi', 29, 48000, N'Khoa hoc', N'1', N'image_sach/khoa11.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Anatole France')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'khoa12', N'Thắm sắc hoa đào', 68, 42000, N'Khoa hoc', N'1', N'image_sach/khoa12.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Vương An Ức')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'khoa13', N'Vô chiêu vô thức & viết ngắn tự chọn', 78, 45000, N'Khoa hoc', N'1', N'image_sach/khoa13.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Phan Cung Việt')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'khoa14', N'Thành phố Quốc Tế', 37, 49000, N'Khoa hoc', N'1', N'image_sach/khoa14.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Don Delillo')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'khoa15', N'Cuộc chiến khuy cúc', 58, 54000, N'Khoa hoc', N'1', N'image_sach/khoa15.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Louis Pergaud')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'khoa16', N'Thiết thư Trúc kiếm - 2 tập', 12, 189000, N'Khoa hoc', N'1', N'image_sach/khoa16.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Bạch Ngọc Thạch')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'khoa17', N'Học viện Công chúa - Princess Academy', 27, 59000, N'Khoa hoc', N'1', N'image_sach/khoa17.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Shannon Hale')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'khoa3', N'Thái độ quyết định thành công', 10, 24000, N'Khoa hoc', N'1', N'image_sach/khoa3.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Wayne Cordeiro')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'khoa4', N'Sydney yêu thương', 20, 38000, N'Khoa hoc', N'1', N'image_sach/khoa4.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Trung Nghĩa')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'khoa5', N'Thành Cổ Tinh Tuyệt', 35, 25000, N'Khoa hoc', N'1', N'image_sach/khoa5.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nguyễn Thị Mơ Mộng')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'khoa7', N'Alice ở xứ sở diệu kì và Alice ở xứ sở trong gương', 48, 58000, N'Khoa hoc', N'1', N'image_sach/khoa7.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Lewis Carrol')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'khoa8', N'Lâu đài thần bí', 50, 59000, N'Khoa hoc', N'1', N'image_sach/khoa8.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Edward Eager')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'khoa9', N'Truyện cổ Andersen', 14, 95000, N'Khoa hoc', N'1', N'image_sach/khoa9.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Hans Christian Andersen')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'l1', N'Từ điển nhân vật lịch sử Việt Nam', 34, 78000, N'Lich su', N'1', N'image_sach/l1.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Đinh Xuân Lâm, Trương Hữu Quýnh')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'l10', N'Chiếc áo Bác Hồ', 60, 24000, N'Lich su', N'1', N'image_sach/l10.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Ngọc Châu')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'l11', N'Thời thanh niên của Bác Hồ', 29, 25500, N'Lich su', N'1', N'image_sach/l11.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Hồng Hà')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'l12', N'Bác Hồ với tuổi trẻ năm châu', 59, 20000, N'Lich su', N'1', N'image_sach/l12.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Trần Đương')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'l13', N'Những mẩu chuyện về đạo đức tác phong của Bác Hồ', 18, 67000, N'Lich su', N'1', N'image_sach/l13.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'NXB Thanh Niên')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'l14', N'Đại cương về văn hóa Việt Nam chặng đường 60 năm', 45, 35000, N'Lich su', N'1', N'image_sach/l14.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'NXB Quốc Gia')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'l15', N'Hoàng Lê Nhất Thống Chí', 100, 56000, N'Lich su', N'1', N'image_sach/l15.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Ngô Gia Văn Phái')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'l16', N'Lịch sử đạo thiên chúa ở Việt Nam', 50, 24000, N'Lich su', N'1', N'image_sach/l16.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Phạm Hồng Lam')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'l17', N'Lịch sử phật giáo', 10, 115000, N'Lich su', N'1', N'image_sach/l17.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nguyễn Tuệ Chân')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'l2', N'Một thiên lịch sử 6 đời Tổng Thống Mỹ Trung', 10, 130000, N'Lich su', N'1', N'image_sach/l2.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Patrick Tyler')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'l3', N'Lịch sử Đông Nam Á', 40, 45000, N'Lich su', N'1', N'image_sach/l3.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Lương Minh-Đỗ Thanh Bình-Trần Thị Vinh')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'l4', N'Lịch sử đạo phật Việt Nam', 67, 36000, N'Lich su', N'1', N'image_sach/l4.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nguyễn Duy Hinh')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'l5', N'Lịch sử bí mật đế chế Hoa Kỳ', 9, 104000, N'Lich su', N'1', N'image_sach/l5.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'John Perkins')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'l6', N'Lịch sử Trung Quốc 5000 năm', 34, 49000, N'Lich su', N'2', N'image_sach/l6.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Lê Hán Đạt-Tào Hán Chương')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'l7', N'9 bản tuyên ngôn nổi tiếng thế giới', 20, 80000, N'Lich su', N'1', N'image_sach/l7.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'NXB Văn hoá thông tin')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'l8', N'Địa danh Hồ Chí Minh', 100, 30000, N'Lich su', N'1', N'image_sach/l8.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'NXB Thanh Niên')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'l9', N'Nguyễn Aí Quốc với nhật ký chìm tàu', 30, 40000, N'Lich su', N'1', N'image_sach/l9.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Phạm Quý Thích')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'ly1', N'Vật lý đại cương', 57, 34000, N'Vat ly', N'1', N'image_sach/ly1.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nguyễn Trong Hiếu')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'ly2', N'Phương pháp luyện thi môn vật lý', 87, 23000, N'Vat ly', N'1', N'image_sach/ly2.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Võ Hải Hà')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'ly3', N'Hoc tốt vật lý 12', 90, 20000, N'Vat ly', N'1', N'image_sach/ly3.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Lê Minh Trí')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'ly4', N'Giải các bài toán vật lý sơ cấp', 100, 35000, N'Vat ly', N'3', N'image_sach/ly4.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Võ Việt Hùng')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'ly5', N'Bài tập và 453 bài toán vật lý 11', 200, 25500, N'Vat ly', N'1', N'image_sach/ly5.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nguyễn Lâm Huy')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'ly6', N'Giáo trình vật lý đại cương A1', 20, 65000, N'Vat ly', N'1', N'image_sach/ly6.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Trương Quang Ngọc')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'ly7', N'168 câu hỏi lý thú về vật lý', 98, 43000, N'Vat ly', N'1', N'image_sach/ly7.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Dương Văn Khoa')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'n1', N'Oxford', 30, 97000, N'Ngoai ngu', N'1', N'image_sach/n1.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Oxford University Press')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'n2', N'Từ điển Anh-Anh-Việt', 20, 36000, N'Ngoai ngu', N'1', N'image_sach/n2.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nhà xuất bản thống kê')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'n3', N'Từ điển Anh-Anh-Việt', 40, 64000, N'Ngoai ngu', N'1', N'image_sach/n3.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Quang Hùng - Ngọc Ánh')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'n4', N'Oxford Wordpower Dictionary with CD-ROM', 50, 180000, N'Ngoai ngu', N'1', N'image_sach/n4.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Oxford University Press')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'n5', N'Tiếng anh 12', 10, 26000, N'Ngoai ngu', N'1', N'image_sach/n7.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nguyễn Tùng')
GO
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'n6', N'Giáo trình tiếng anh khoa học máy tính', 28, 78000, N'Ngoai ngu', N'1', N'image_sach/n6.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Quang Huy-Ngọc Ánh')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'o1', N'Đề thi tuyển sinh địa lý', 100, 25000, N'On thi CD-DH', N'1', N'image_sach/o1.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nguyễn Đức Vũ')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'o2', N'Tuyển chọn những bài ôn luyện thi CĐ-ĐH môn địa lý', 50, 18000, N'On thi CD-DH', N'1', N'image_sach/o2.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Phí Công Việt')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'o3', N'Ôn thi tốt nghiệp THPT-CĐ-ĐH môn Tiếng Anh', 40, 34000, N'On thi CD-DH', N'1', N'image_sach/o3.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nguyễn Thanh Nam')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'o4', N'Chuyên đề khảo sát hàm số luyện thi CĐ-ĐH', 30, 40000, N'On thi CD-DH', N'1', N'image_sach/o4.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Trần Đức Huyên')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'o5', N'Chuẩn bị ôn thi tốt nghiệp THPT-CĐ-ĐH môn Vật lý', 20, 35000, N'On thi CD-DH', N'1', N'image_sach/o5.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nguyễn Minh Tuân')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'o6', N'Hướng dẫn ôn tập thi môn toán', 46, 26000, N'On thi CD-DH', N'3', N'image_sach/o6.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Trần Công Mân')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'o7', N'Chuẩn bị ôn thi tốt nghiệp THPT-CĐ-ĐH môn Hoá Học', 78, 47000, N'On thi CD-DH', N'1', N'image_sach/o7.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nguyễn Huy Hoàng')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'o8', N'Luyện thi sinh học', 57, 43000, N'On thi CD-DH', N'1', N'image_sach/o8.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Tàu Minh Việt')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N't1', N'Tâm lý làm sáng của trẻ em Việt Nam', 50, 34000, N'Tam ly', N'1', N'image_sach/t1.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Trần Thị Kim Yến')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N't2', N'Tư vấn tâm lý căn bản', 30, 23000, N'Tam ly', N'1', N'image_sach/t2.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nguyễn Thị Như Lan')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N't3', N'Tâm lý học', 34, 56000, N'Tam ly', N'1', N'image_sach/t3.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Đào Duy Quang')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N't4', N'Chuẩn bị tâm lý tuổi 40', 60, 29000, N'Tam ly', N'1', N'image_sach/t4.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Kajuri')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N't5', N'Mãi thấm màu tình bạn', 67, 45000, N'Tam ly', N'1', N'image_sach/t5.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nguyễn Trung Trực')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N't6', N'Chuẩn bị tâm lý tuổi 50', 23, 17000, N'Tam ly', N'1', N'image_sach/t6.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Kajuri')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N't7', N'Sức mạnh của trí tuệ cảm xúc', 40, 48000, N'Tam ly', N'1', N'image_sach/t7.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Roger Fisher & Daniel Sapiro')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N't8', N'Gợi ý giải đáp những câu hỏi cho trẻ em', 20, 19000, N'Tam ly', N'1', N'image_sach/t8.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Liêm Trinh - Nguyễn Nghiêm')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'tin1', N'Cấu trúc dữ liệu và giải thuật', 40, 30000, N'Tin', N'1', N'image_sach/tin1.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Đỗ Xuân Lôi')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'tin10', N'Nâng Cấp Bảo Trì Và Xử Lý Phần Cứng Máy Tính tập 2', 200, 45000, N'Tin', N'2', N'image_sach/tin10.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Michael Miller - Biên dịch Thanh Nguyên')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'tin11', N'Nâng Cấp Bảo Trì Và Xử Lý Phần Cứng Máy Tính tập 1', 100, 45000, N'Tin', N'2', N'image_sach/tin11.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Michael Miller - Biên dịch Thanh Nguyên')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'tin12', N'Giáo Trình Thực Hành Flash', 120, 35000, N'Tin', N'1', N'image_sach/tin12.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Phạm Quang  Hân - Hồ Chí Hoà ')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'tin13', N'Làm chủ Windows Server 2003- Tập 2', 40, 153000, N'Tin', N'2', N'image_sach/tin13.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Phạm Hoàng Dũng')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'tin14', N'Sử dụng Illustrator CS cho người mới bắt đầu', 30, 46000, N'Tin', N'1', N'image_sach/tin14.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'KS. Ngọc Tuấn')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'tin15', N'Tinh chỉnh sự thực thi và tối ưu hóa ASP.NET', 50, 38000, N'Tin', N'1', N'image_sach/tin15.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Ban biên soạn Hoàn Vũ-Chủ biên Phạm Đăng Khoa')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'tin16', N'Đồ họa vi tính Photoshop-Thật là đơn giản', 20, 60000, N'Tin', N'1', N'image_sach/tin16.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Dương Mạnh Hùng - Lê Huy')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'tin2', N'Thiết kế sản phẩm với Cimatron E7.0', 20, 63000, N'Tin', N'1', N'image_sach/tin2.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nguyễn Trọng Hữu')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'tin3', N'Thực hành Visual C++ 6.0', 12, 40000, N'Tin', N'1', N'image_sach/tin3.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Trương Công Tuấn')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'tin4', N'3D Studio Max 5.0', 12, 32000, N'Tin', N'1', N'image_sach/tin4.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Trần Xuân Lôi')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'tin5', N'Thiết Kế Bản Vẽ Kỹ Thuật Với AUTOCAD 2005', 25, 90000, N'Tin', N'1', N'image_sach/tin5.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Thuận Thành-Thành Tân')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'tin6', N'Lý thuyết cơ cở dữ liệu', 58, 32000, N'Tin', N'1', N'image_sach/tin6.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Đõ tiến Tùng')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'tin7', N'Hướng dẫn sử dụng Photoshop 8.0', 30, 80000, N'Tin', N'1', N'image_sach/tin7.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nguyễn Tuấn Ngọc')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'tin8', N'Giáo Trình Cấu Trúc Máy Tính', 20, 45000, N'Tin', N'1', N'image_sach/tin8.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Đặng Văn Anh')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'tin9', N'Tự học thiết kế Web và quản lý Web', 15, 35000, N'Tin', N'1', N'image_sach/tin9.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nguyễn Đình Tuấn')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'toan1', N'Giải tích', 10, 25000, N'Toan', N'1', N'image_sach/toan1.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nguyễn Gia Định')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'toan10', N'Toán hình giải tích 12', 39, 32000, N'Toan', N'1', N'image_sach/toan10.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nguyễn Huy Long')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'toan2', N'Cẩm Nang Toán Giải Tích', 100, 30000, N'Toan', N'1', N'image_sach/toan2.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Hoàng Văn Phong')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'toan3', N'Giải Tích Số', 300, 25000, N'Toan', N'1', N'image_sach/toan3.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Lê Minh Nghĩa')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'toan4', N'Giáo Trình Toán Giải Tích - Tập', 120, 19000, N'Toan', N'2', N'image_sach/toan4.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nguyễn Nhật Minh')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'toan5', N'Toán Học Với Đời Sống Sản Xuất Quốc Phòng', 100, 23000, N'Toan', N'2', N'image_sach/toan5.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Trần Như Lệ')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'toan6', N'Tuyển Chọn 351 Bài Toán Giải Tích Tổ', 50, 35000, N'Toan', N'1', N'image_sach/toan6.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nguyễn Đình Anh')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'toan7', N'Toán Hình Giải Tích 12', 35, 26000, N'Toan', N'2', N'image_sach/toan7.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Đào Văn Thi')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'toan8', N'Ảo thuật toán học', 100, 23000, N'Toan', N'1', N'image_sach/toan8.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Matin Ganơ')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'toan9', N'Toán cao cấp giải tich', 40, 38000, N'Toan', N'2', N'image_sach/toan9.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Phạm Hồng Danh')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'v1', N'Chuyện chưa biết về nhà văn Nam Cao', 101, 35000, N'Van', N'1', N'image_sach/v1.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Trần Thị Hồng')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'v10', N'Tắt Đèn 1', 23, 23000, N'Van', N'2', N'image_sach/v10.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Ngô Tất Tố')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'v11', N'Thằng mõ trâu', 69, 27000, N'Van', N'1', N'image_sach/v11.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Phạm Ngọc Tiến')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'v12', N'Huế - mùa mai đỏ', 10, 110000, N'Van', N'1', N'image_sach/v12.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Xuân Thiều')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'v13', N'Chí Phèo', 90, 34000, N'Van', N'1', N'image_sach/v13.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nam Cao')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'v14', N'Thế giới Chữ Nghĩa trong thơ ca Tình Yêu', 50, 36000, N'Van', N'1', N'image_sach/v14.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Dương Văn Khoa')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'v15', N'Chuyện tử tù Lê Quang Vịnh', 70, 30000, N'Van', N'1', N'image_sach/v15.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Ngô Minh')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'v16', N'Truyện ngắn đương đại Việt Nam- tập 2', 40, 45000, N'Van', N'2', N'image_sach/v16.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nguyễn Lâm Huy')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'v17', N'Kiều', 100, 32000, N'Van', N'1', N'image_sach/v17.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nguyễn Du')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'v18', N'Cuộc đời và trang viết Nhìn nhận - đánh giá', 35, 65000, N'Van', N'1', N'image_sach/v18.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Lê Tuấn Anh')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'v19', N'Truyện ngắn đương đại Việt Nam- tập 1', 65, 45000, N'Van', N'2', N'image_sach/v19.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nguyễn Lâm Huy')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'v2', N'Hành trang tuổi mười tám', 20, 23000, N'Van', N'1', N'image_sach/v2.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Kim Nguyễn')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'v3', N'Xuân Từ Chiều', 100, 39000, N'Van', N'1', N'image_sach/v3.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Y Ban')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'v4', N'Ca Dao Việt Nam Va Những Lời Bình', 200, 23500, N'Van', N'1', N'image_sach/v4.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Lê Nam')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'v5', N'Tuyển tập truyện ngắn hay', 100, 45000, N'Van', N'1', N'image_sach/v5.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Võ Việt Hùng')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'v6', N'Giông Tố', 32, 35000, N'Van', N'1', N'image_sach/v6.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Ngô Tất Tố')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'v7', N'Hoàng Như Ma', 50, 114000, N'Van', N'1', N'image_sach/v7.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Trần Hữu Tá')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'v8', N'Hòn Đất', 20, 30000, N'Van', N'1', N'image_sach/v8.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Lê Hữu Nghị')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'v9', N'Tắt Đèn', 35, 25000, N'Van', N'2', N'image_sach/v9.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Ngô Tất Tố')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'y1', N'Tỏi với sức khỏe con người', 35, 26000, N'Y hoc', N'1', N'image_sach/y1.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Lê Minh Trí')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'y10', N'Bệnh tiền liệt tuyến  giải pháp dự phòng-điều trị', 340, 18000, N'Y hoc', N'1', N'image_sach/y10.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Ngô Tín')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'y11', N'Cách ăn uống phòng bệnh ung thư', 56, 42000, N'Y hoc', N'1', N'image_sach/y11.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Ngọc Phương')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'y12', N'Cách phòng ngừa điều trị bệnh Gút', 78, 45000, N'Y hoc', N'1', N'image_sach/y12.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'BS Mạnh Hải')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'y13', N'Bệnh gan mật những điều cần biết', 90, 37000, N'Y hoc', N'1', N'image_sach/y13.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'BS Bạch Minh')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'y14', N'Vị thuốc chữa bệnh bằng rau củ quả', 87, 29500, N'Y hoc', N'1', N'image_sach/y14.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'BS Lê Hữu Phước')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'y15', N'Trà với sức khoẻ và sắc đẹp', 99, 25000, N'Y hoc', N'1', N'image_sach/y15.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Lương Quỳnh Bạch')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'y16', N'Cẩm nang sức khoẻ gia đình', 20, 120000, N'Y hoc', N'1', N'image_sach/y16.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Nguyễn Lân Đính')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'y2', N'Phòng chữa bệnh béo Tri thức cơ sở của bệnh béo', 30, 10500, N'Y hoc', N'1', N'image_sach/y2.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Lưu Diễm Kiêu')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'y3', N'Bệnh Tăng Huyết Áp Cách Phòng Và Điều Trị', 20, 35000, N'Y hoc', N'1', N'image_sach/y3.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N' Bạch Minh')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'y4', N'Các bệnh ung thư thường gặp và đông y', 100, 34000, N'Y hoc', N'1', N'image_sach/y4.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N' Bác sĩ Hùng Minh')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'y5', N'34 bài thuốc chữa bệnh từ rau quả', 110, 20000, N'Y hoc', N'1', N'image_sach/y5.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Lê Hạnh')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'y6', N'Ấn huyệt bằng tay chữa bệnh', 120, 30000, N'Y hoc', N'1', N'image_sach/y6.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Võ Hải Hà')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'y7', N'Bạn chính là bác sỹ tốt nhất của mình', 35, 40000, N'Y hoc', N'1', N'image_sach/y7.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'Lê Duyên Hải')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'y8', N'Từ điển Y học', 200, 71000, N'Y hoc', N'1', N'image_sach/y8.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'BS Đặng Văn Chí')
INSERT [dbo].[sach] ([masach], [tensach], [soluong], [gia], [maloai], [sotap], [anh], [NgayNhap], [tacgia]) VALUES (N'y9', N'Các bệnh về da liễu phát hiện và điều trị', 300, 30000, N'Y hoc', N'1', N'image_sach/y9.jpg', CAST(N'2017-09-15 19:25:58.897' AS DateTime), N'BS Lê Dung')
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_hoadon] FOREIGN KEY([MaHoaDon])
REFERENCES [dbo].[hoadon] ([MaHoaDon])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_hoadon]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_sach] FOREIGN KEY([MaSach])
REFERENCES [dbo].[sach] ([masach])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_sach]
GO
ALTER TABLE [dbo].[hoadon]  WITH CHECK ADD  CONSTRAINT [FK_hoadon_KhachHang] FOREIGN KEY([makh])
REFERENCES [dbo].[KhachHang] ([makh])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[hoadon] CHECK CONSTRAINT [FK_hoadon_KhachHang]
GO
ALTER TABLE [dbo].[sach]  WITH CHECK ADD  CONSTRAINT [FK_sach_loai] FOREIGN KEY([maloai])
REFERENCES [dbo].[loai] ([maloai])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[sach] CHECK CONSTRAINT [FK_sach_loai]
GO
/****** Object:  StoredProcedure [dbo].[TimKiem]    Script Date: 12/26/2023 2:28:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[TimKiem](@bien nvarchar(5))
as
  select * from sach where maloai =@bien

GO
/****** Object:  StoredProcedure [dbo].[TimMaLoai]    Script Date: 12/26/2023 2:28:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[TimMaLoai]( @maloai nvarchar(50))
as
select * from sach where maloai=@maloai

GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[41] 4[21] 2[23] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "ChiTietHoaDon"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 125
               Right = 198
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "loai"
            Begin Extent = 
               Top = 6
               Left = 236
               Bottom = 95
               Right = 396
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "sach"
            Begin Extent = 
               Top = 6
               Left = 434
               Bottom = 125
               Right = 594
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
      Begin ColumnWidths = 9
         Width = 284
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'abc'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=1 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'abc'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[40] 4[20] 2[20] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "loai"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 95
               Right = 198
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "sach"
            Begin Extent = 
               Top = 6
               Left = 236
               Bottom = 125
               Right = 396
            End
            DisplayFlags = 280
            TopColumn = 5
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
      Begin ColumnWidths = 9
         Width = 284
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'HtSach'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=1 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'HtSach'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[41] 4[21] 2[16] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "ChiTietHoaDon"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 125
               Right = 198
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "hoadon"
            Begin Extent = 
               Top = 6
               Left = 236
               Bottom = 125
               Right = 396
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "loai"
            Begin Extent = 
               Top = 6
               Left = 434
               Bottom = 95
               Right = 594
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "sach"
            Begin Extent = 
               Top = 0
               Left = 588
               Bottom = 119
               Right = 748
            End
            DisplayFlags = 280
            TopColumn = 2
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
      Begin ColumnWidths = 9
         Width = 284
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'rrr'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane2', @value=N'
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'rrr'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=2 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'rrr'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[37] 4[37] 2[1] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "loai"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 95
               Right = 198
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "sach"
            Begin Extent = 
               Top = 6
               Left = 236
               Bottom = 125
               Right = 396
            End
            DisplayFlags = 280
            TopColumn = 1
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
      Begin ColumnWidths = 9
         Width = 284
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 12
         Column = 1440
         Alias = 2505
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'tk'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=1 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'tk'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[41] 4[21] 2[11] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = -96
         Left = 0
      End
      Begin Tables = 
         Begin Table = "ChiTietHoaDon"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 125
               Right = 198
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "hoadon"
            Begin Extent = 
               Top = 6
               Left = 236
               Bottom = 125
               Right = 396
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "loai"
            Begin Extent = 
               Top = 6
               Left = 434
               Bottom = 95
               Right = 594
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "sach"
            Begin Extent = 
               Top = 96
               Left = 434
               Bottom = 215
               Right = 594
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
      Begin ColumnWidths = 9
         Width = 284
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   E' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'Vabcd'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane2', @value=N'nd
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'Vabcd'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=2 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'Vabcd'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[41] 4[42] 2[13] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "ChiTietHoaDon"
            Begin Extent = 
               Top = 9
               Left = 57
               Bottom = 206
               Right = 279
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "hoadon"
            Begin Extent = 
               Top = 9
               Left = 336
               Bottom = 206
               Right = 558
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "KhachHang"
            Begin Extent = 
               Top = 9
               Left = 615
               Bottom = 206
               Right = 837
            End
            DisplayFlags = 280
            TopColumn = 3
         End
         Begin Table = "sach"
            Begin Extent = 
               Top = 9
               Left = 894
               Bottom = 206
               Right = 1116
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 3370
         Alias = 1650
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'VAdminXacNhan'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=1 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'VAdminXacNhan'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[30] 4[37] 2[20] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "sach"
            Begin Extent = 
               Top = 6
               Left = 240
               Bottom = 125
               Right = 400
            End
            DisplayFlags = 280
            TopColumn = 2
         End
         Begin Table = "hoadon"
            Begin Extent = 
               Top = 0
               Left = 445
               Bottom = 119
               Right = 605
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "ChiTietHoaDon"
            Begin Extent = 
               Top = 4
               Left = 31
               Bottom = 123
               Right = 191
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
      Begin ColumnWidths = 9
         Width = 284
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'Vhoadon'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=1 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'Vhoadon'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[35] 4[46] 2[13] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "ChiTietHoaDon"
            Begin Extent = 
               Top = 9
               Left = 57
               Bottom = 228
               Right = 279
            End
            DisplayFlags = 280
            TopColumn = 1
         End
         Begin Table = "hoadon"
            Begin Extent = 
               Top = 9
               Left = 336
               Bottom = 206
               Right = 558
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "KhachHang"
            Begin Extent = 
               Top = 9
               Left = 615
               Bottom = 206
               Right = 837
            End
            DisplayFlags = 280
            TopColumn = 1
         End
         Begin Table = "sach"
            Begin Extent = 
               Top = 9
               Left = 894
               Bottom = 206
               Right = 1116
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
      Begin ColumnWidths = 9
         Width = 284
         Width = 1000
         Width = 1000
         Width = 1000
         Width = 1000
         Width = 1000
         Width = 1000
         Width = 1000
         Width = 1000
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 2640
         Alias = 1830
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'Vlichsu'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane2', @value=N'
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'Vlichsu'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=2 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'Vlichsu'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[41] 4[21] 2[14] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "ChiTietHoaDon"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 125
               Right = 198
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "hoadon"
            Begin Extent = 
               Top = 6
               Left = 236
               Bottom = 125
               Right = 396
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "loai"
            Begin Extent = 
               Top = 6
               Left = 434
               Bottom = 95
               Right = 594
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "sach"
            Begin Extent = 
               Top = 5
               Left = 580
               Bottom = 124
               Right = 740
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
      Begin ColumnWidths = 9
         Width = 284
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'Vqq'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane2', @value=N'
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'Vqq'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=2 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'Vqq'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[40] 4[20] 2[20] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = -172
         Left = 0
      End
      Begin Tables = 
         Begin Table = "ChiTietHoaDon"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 125
               Right = 198
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "hoadon"
            Begin Extent = 
               Top = 6
               Left = 434
               Bottom = 125
               Right = 594
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "KhachHang"
            Begin Extent = 
               Top = 114
               Left = 236
               Bottom = 233
               Right = 396
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "loai"
            Begin Extent = 
               Top = 126
               Left = 38
               Bottom = 215
               Right = 198
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "sach"
            Begin Extent = 
               Top = 126
               Left = 434
               Bottom = 245
               Right = 594
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or =' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'VTamBay'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane2', @value=N' 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'VTamBay'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=2 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'VTamBay'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[41] 4[14] 2[15] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "ChiTietHoaDon"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 125
               Right = 198
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "hoadon"
            Begin Extent = 
               Top = 6
               Left = 236
               Bottom = 125
               Right = 396
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "KhachHang"
            Begin Extent = 
               Top = 6
               Left = 434
               Bottom = 125
               Right = 594
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "loai"
            Begin Extent = 
               Top = 126
               Left = 38
               Bottom = 215
               Right = 198
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "sach"
            Begin Extent = 
               Top = 126
               Left = 236
               Bottom = 245
               Right = 396
            End
            DisplayFlags = 280
            TopColumn = 2
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
      Begin ColumnWidths = 9
         Width = 284
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 900
         ' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'Vtest'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane2', @value=N'Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'Vtest'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=2 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'Vtest'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[23] 4[43] 2[16] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "loai"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 95
               Right = 198
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "sach"
            Begin Extent = 
               Top = 6
               Left = 236
               Bottom = 125
               Right = 396
            End
            DisplayFlags = 280
            TopColumn = 1
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
      Begin ColumnWidths = 9
         Width = 284
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 12
         Column = 1440
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'VTK'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=1 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'VTK'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[19] 4[43] 2[11] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "loai"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 95
               Right = 198
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "sach"
            Begin Extent = 
               Top = 0
               Left = 244
               Bottom = 119
               Right = 404
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "KhachHang"
            Begin Extent = 
               Top = 16
               Left = 547
               Bottom = 135
               Right = 707
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "ChiTietHoaDon"
            Begin Extent = 
               Top = 96
               Left = 38
               Bottom = 215
               Right = 198
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "hoadon"
            Begin Extent = 
               Top = 97
               Left = 439
               Bottom = 216
               Right = 599
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
      Begin ColumnWidths = 9
         Width = 284
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 12
         Column = 1440
         Alias = 900
         Ta' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'VTKabc'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane2', @value=N'ble = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'VTKabc'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=2 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'VTKabc'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[40] 4[30] 2[10] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = -96
         Left = 0
      End
      Begin Tables = 
         Begin Table = "sach"
            Begin Extent = 
               Top = 0
               Left = 206
               Bottom = 119
               Right = 366
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "loai"
            Begin Extent = 
               Top = 2
               Left = 535
               Bottom = 91
               Right = 695
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "hoadon"
            Begin Extent = 
               Top = 47
               Left = 375
               Bottom = 166
               Right = 535
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "ChiTietHoaDon"
            Begin Extent = 
               Top = 36
               Left = 0
               Bottom = 155
               Right = 160
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "KhachHang"
            Begin Extent = 
               Top = 96
               Left = 573
               Bottom = 215
               Right = 733
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
      Begin ColumnWidths = 9
         Width = 284
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 12
         Column = 1440
         Alias = 900
         ' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'Vtktest'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane2', @value=N'Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'Vtktest'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=2 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'Vtktest'
GO

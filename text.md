I. Create project
1. tạo project có các dependency: spring-boot-starter-data-jpa, spring-boot-starter-web, spring-boot-devtools, mysql-connector-j,lombok, spring-boot-starter-test, spring-boot-starter-jdbc.
2. kết nối với cơ sở dữ liệu qua JdbcTemplate

II. Xây dựng cấu trúc dự án
1.
my-springboot-project/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/example/project/
│   │   │       ├── MySpringBootApplication.java          # Main class
│   │   │
│   │   │       ├── config/                               # Các lớp cấu hình
│   │   │       │   ├── 
│   │   │       │   
│   │   │
│   │   │       ├── controller/                           # REST Controllers
│   │   │       │   ├── 
│   │   │
│   │   │       ├── dto/                                  # DTOs
│   │   │       │   ├── 
│   │   │
│   │   │       ├── entity/                               # JPA Entities
│   │   │       │   ├── 
│   │   │
│   │   │       ├── exception/                            # Xử lý ngoại lệ
│   │   │       │   ├── 
│   │   │
│   │   │       ├── repository/                           # Spring Data Repositories
│   │   │       │   ├── 
│   │   │
│   │   │       ├── security/                             # Xác thực + bảo mật (JWT)
│   │   │       │   ├── 
│   │   │
│   │   │       ├── service/                              # Business logic
│   │   │       │   ├── 
│   │   │
│   │   │       ├── mapper/                               # Dùng nếu bạn có DTO ↔ Entity
│   │   │       │   ├── 
│   │   │
│   │   │       ├── constant/                             # Các hằng số dùng chung
│   │   │       │   ├── 
│   │   │       
│   │   │       ├── request/
│   │   │       │   ├──
│   │   │
│   │   │       ├── response/                             # Định dạng phản hồi chuẩn hóa
│   │   │       │   ├──
│   │   │
│   │   │       ├── util/                                 # Các tiện ích dùng chung
│   │   │       │   ├── 
│   │
│   │   ├── resources/
│   │       ├── application.properties                    # Cấu hình chính
│   │       ├── static/                                   # JS, CSS, image (nếu dùng web)
│   │       ├── templates/                                # HTML Thymeleaf (nếu dùng)
│   │       ├── db/
│   │           ├── migration/
│   │               ├── V1__init_schema.sql
│   │               ├── V2__insert_sample_data.sql
│
├── src/
│   ├── test/
│       ├── java/com/example/project/
│           ├── StudentServiceTest.java                   # Unit test
│           ├── StudentControllerTest.java                # REST controller test
│
├── pom.xml / build.gradle                                # File cấu hình Maven/Gradle
├── README.md                                              # Mô tả project
├── .gitignore                                             # File Git ignore

2. 
AuthController.java               # Quản lí đăng nhập
UserCatalogueController.java      # Quản lí nhóm
UserController.java               # Quản lí người dùng

III.migartion và đưa dữ liệu vào database
1.
tạo bảng student và bảng lớp đánh khóa ngoại cho bảng student và thêm cột age vào bảng student.
2.
taoj file DatabaseSeeder đưa chèn dữ liệu đầu vào khi khởi động.
3.
tạo file SecurityConfig trong folder config và viết mã passwordEncoder.

IV.xây dựng lớp repository
1. sử dụng JpaRepository để đưa dữ liệu vào database

V. validate dữ liệu
1. Sử dung @Validated và @Valid trong AuthController

VI. Xây dựng chuỗi JWT 

dùng dependency 
        <dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-api</artifactId>
			<version>0.11.5</version>
		</dependency>
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-impl</artifactId>
			<version>0.11.5</version>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-jackson</artifactId>
			<version>0.11.5</version>
			<scope>runtime</scope>
		</dependency>
mục tiêu tạo ra được chuỗi jwt
tạo ra chuỗi jwt lưu vào application.properties sử dụng HS512


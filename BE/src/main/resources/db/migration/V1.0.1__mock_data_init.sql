INSERT INTO user (is_host, is_super_host, is_admin, email, nickname, github_token, password)
VALUES (TRUE, TRUE, FALSE, 'ksundong@gmail.com', 'Dion', '', NULL);

INSERT INTO user (email, nickname, github_token, password)
VALUES ('zello@gmail.com', 'Zello', '', NULL);

INSERT INTO user (is_host, email, nickname, github_token, password)
VALUES (TRUE, 'han@gmail.com', 'Han', '', NULL);

INSERT INTO room (max_person_count, main_image, title, daily_price, cleaning_price, service_price,
                  commission, country, location, rating, review_count, user_id)
VALUES (2, 'https://a0.muscache.com/im/pictures/2b201442-1c0a-468b-a9fa-0f0b5ea8782b.jpg?im_w=1200',
        'L\'Or Vert★VUE Cité Médiévale★160m CITE★Netflix', 43, 10, 5, 5, '프랑스',
        st_GeomFromText('POINT(48.8032 2.3511)'), 3.57, 93, 1);
INSERT INTO room (max_person_count, main_image, title, daily_price, cleaning_price, service_price,
                  commission, country, location, rating, review_count, user_id)
VALUES (2,
        'https://a2.muscache.com/im/pictures/9dc1cb72-60a5-45f8-a9c9-75f149b85d02.jpg?aki_policy=large',
        'Mark P.Coleman', 506, 50, 20, 30, '스페인', st_GeomFromText('POINT(40.4637 3.7493)'), 3.63,
        111, 3);
INSERT INTO room (max_person_count, main_image, title, daily_price, cleaning_price, service_price,
                  commission, country, location, rating, review_count, user_id)
VALUES (5,
        'https://a2.muscache.com/im/pictures/e6ffb84e-b386-4b48-9b00-7d7e65ca1584.jpg?aki_policy=large',
        'Welcome to cozy groundfloor 2rm apt', 375, 30, 50, 20, '미국',
        st_GeomFromText('POINT(37.0902 95.7129)'), 4.1, 312, 1);
INSERT INTO room (max_person_count, main_image, title, daily_price, cleaning_price, service_price,
                  commission, country, location, rating, review_count, user_id)
VALUES (7,
        'https://a2.muscache.com/im/pictures/3cef9e2e-25a6-49c5-aa86-c705c5c7cc67.jpg?aki_policy=large',
        'Private Apartment!', 296, 20, 20, 15, '프랑스', st_GeomFromText('POINT(46.2276 2.2137)'),
        2.93, 33, 3);
INSERT INTO room (max_person_count, main_image, title, daily_price, cleaning_price, service_price,
                  commission, country, location, rating, review_count, user_id)
VALUES (8,
        'https://a2.muscache.com/im/pictures/256ae775-e25b-4d99-8cd7-00855ce251f8.jpg?aki_policy=large',
        'Sunny apartment in Boston hosts 6', 244, 24, 10, 30, '스위스',
        st_GeomFromText('POINT(46.8182 8.2275)'), 3.12, 13,
        1);
INSERT INTO room (max_person_count, main_image, title, daily_price, cleaning_price, service_price,
                  commission, country, location, rating, review_count, user_id)
VALUES (11, 'https://a1.muscache.com/im/pictures/89438360/ad8d6e7b_original.jpg?aki_policy=large',
        'Fresh, Clean and Green Private Room', 235, 10, 30, 20, '영국',
        st_GeomFromText('POINT(55.3781 3.4360)'), 3.09, 18,
        1);
INSERT INTO room (max_person_count, main_image, title, daily_price, cleaning_price, service_price,
                  commission, country, location, rating, review_count, user_id)
VALUES (14, 'https://a2.muscache.com/im/pictures/24731791/1bf3bc7c_original.jpg?aki_policy=large',
        'Awesome Room', 235, 23, 14, 20, '프랑스', st_GeomFromText('POINT(45.7640 4.8357)'), 3.77, 51,
        3);
INSERT INTO room (max_person_count, main_image, title, daily_price, cleaning_price, service_price,
                  commission, country, location, rating, review_count, user_id)
VALUES (16, 'https://a2.muscache.com/im/pictures/79747964/7e73da70_original.jpg?aki_policy=large',
        'Private Rm near T Separate Bunkbeds', 233, 13, 23, 11, '이탈리아',
        st_GeomFromText('POINT(41.8719 12.5674)'), 3.99, 101, 1);
INSERT INTO room (max_person_count, main_image, title, daily_price, cleaning_price, service_price,
                  commission, country, location, rating, review_count, user_id)
VALUES (4,
        'https://a2.muscache.com/im/pictures/c13e5ae7-7b09-42e3-b16f-331795400a93.jpg?aki_policy=large',
        'PrivRoom+Bath In Roslindale/Boston', 209, 20, 14, 13, '독일',
        st_GeomFromText('POINT(51.1657 10.4515)'), 4.53, 189
            3);
INSERT INTO room (max_person_count, main_image, title, daily_price, cleaning_price, service_price,
                  commission, country, location, rating, review_count, user_id)
VALUES (10, 'https://a2.muscache.com/im/pictures/100311920/8a1547f9_original.jpg?aki_policy=large',
        'Sofa bed in cozy, clean apartment', 180, 23, 41, 13, '독일',
        st_GeomFromText('POINT(50.1109 8.6821)'), 4.91, 323,
        1);

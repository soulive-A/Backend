-- 유저
INSERT INTO  soullive.user (user_id, password, phone_number) VALUES (1, 'password', '010-0000-0000');

-- 모델
INSERT INTO  soullive.model (model_id, model_name, birth, age, job, info, agency, ai_rate, image_url)
VALUES
    (1, '김희애', '1967-04-23', '56세', '텔런트/영화배우', '', 'YG 엔터테인먼트', 4.0, 'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/heeae.png'),
    (2, '한지민', '1982-11-05', '41세', '배우', '', 'BH 엔터테인먼트', 3.0, 'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/hanjimin.png'),
    (3, '김고은', '1991-07-02', '32세', '배우', '', 'BH 엔터테인먼트', 3.0, 'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/kimgoeun.png'),

    (4, '아이유', null,null,'가수',null,null,null,'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/iu.png'),
    (5, '수지',null,null,'가수',null,null,null,'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/suzy.png'),
    (6, '뉴진스',null,null,'가수',null,null,null,'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/newjeans.png'),
    (7, '정국', null, null,'가수',null,null,null,'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/jungkook.png'),
    (8, '박은빈',null,null,'배우',null,null,null,'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/parkeunbin.png'),
    (9, '송강',null,null,'배우',null,null,null,'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/songkang.png'),
    (10,'나인우',null,null,'배우',null,null,null,'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/nainwoo.png'),
    (11,'빠더너스',null,null,'유튜버',null,null,null,'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/bdns.png'),
    (12,'침착맨',null,null,'유튜버',null,null,null,'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/calmdownman.png'),
    (13,'피식대학',null,null,'유튜버',null,null,null,'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/psickuniv.png'),
    (14,'성해은',null,null,'유튜버',null,null,null,'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/haeeun.png');



-- 모델소개
INSERT INTO  soullive.model_introduction (model_id, model_introduction_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);

-- 모델소개 > 모델이미지키워드
INSERT INTO  soullive.model_image_keyword (model_image_keyword_id, model_id, keyword)
VALUES
    (1, 1, '#세련됨'),
    (2, 1, '#프로페셔널'),
    (3, 1, '#대중에게 친숙한'),
    (4, 1, '#우아한'),
    (5, 1, '#프리미엄'),
    (6, 1, '#럭셔리함'),
    (7, 1, '#신뢰감'),
    (8, 2, '#깨끗한'),
    (9, 2, '#다재다능한'),
    (10, 2, '#대중에게 친숙한'),
    (11, 2, '#강인한'),
    (12, 2, '#예술적인'),
    (13, 2, '#섬세한'),
    (14, 2, '#귀여운'),
    (15, 3, '#세련됨'),
    (16, 3, '#청순한'),
    (17, 3, '#사랑스러운'),
    (18, 3, '#자연스러운'),
    (19, 3, '#예술적인'),
    (20, 3, '#명량한'),
    (21, 3, '#포근한');

-- 모델소개 > 최근 작품
INSERT INTO  soullive.model_recent_work (model_recent_work_id, `year`, model_id, category, genre, image_url, `role`, title)
VALUES
    (1, 2024, 1, '영화', '범죄', 'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/heeae_recentwork1.png', '심은조역 (주연)', '데드맨'),
    (2, 2023, 1, '드라마', '드라마, 정치', 'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/heeae_recentwork2.png', '황도희역 (주연)', '퀸메이커'),
    (3, 2020, 1, '드라마', '가족, 멜로', 'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/heeae_recentwork3.png', '지선우역 (주연)', '부부의 세계'),

    (4, 2023, 2, '드라마', '판타지', 'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/jimin_recentwork1.png', '봉예분역 (주연)', '힙하게'),
    (5, 2022, 2, '드라마', '가족', 'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/jimin_recentwork2.png', '이영옥역 (주연)', '우리들의 블루스'),
    (6, 2022, 2, '드라마', 'SF', 'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/jimin_recentwork3.png', '차이후역 (주연)', '욘더'),

    (7, 2024, 3, '영화', '스릴러', 'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/goeun_recentwork1.png', '이화림역 (주연)', '파묘'),
    (8, 2022, 3, '영화', '뮤지컬', 'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/goeun_recentwork2.png', '설희역 (주연)', '영웅'),
    (9, 2022, 3, '드라마', '미스터리', 'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/goeun_recentwork3.png', '오인주역 (주연)', '작은아씨들');

-- 모델소개 > 최근 광고 활동
INSERT INTO  soullive.model_recent_advertisement (model_recent_advertisement_id, `year`, model_id, brand, image_url)
VALUES
    (1, 2024, 1, '우리은행 투체어스', 'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/heeae_recentadvertisement1.png'),
    (2, 2021, 1, '트렌비', 'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/heeae_recentadvertisement2.png'),
    (3, 2019, 1, 'LG 프라엘', 'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/heeae_recentadvertisement3.png'),

    (4, 2023, 2, '삼성화재', 'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/jimin_recentadvertisement1.png'),
    (5, 2022, 2, '탑스탭 세제', 'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/jimin_recentadvertisement2.png'),
    (6, 2020, 2, '동인비', 'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/jimin_recentadvertisement3.png'),

    (7, 2019, 3, '듀오랩', 'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/goeun_recentadvertisement1.png'),
    (8, 2021, 3, '디스커버리 익스페디션', 'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/goeun_recentadvertisement2.png'),
    (9, 2024, 3, '네스프레소', 'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/goeun_recentadvertisement3.png');

-- 모델 화제성
INSERT INTO  soullive.model_popularity (model_popularity_id,model_id,score_url,ai_comment,sns_url,search_url,brand_score_url)
values
    (1,1,'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/heeae_popularity.png','최근 화제성에서는 다소 약한 모습을 보여주고 있지만 3040 남녀 모두에게 높은 인지도를 갖고 있고 앞으로 2개의 주연 활동을 앞두고 있어 더 큰 화제성을 갖을 것으로 예상됩니다.'
    ,'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/heeae_popularity_sns.png','https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/heeae_search.png','https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/heeae_popularity_brand.png'),
    (2,2,'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/jimin_popularity.png','한지민은 20대부터 40대까지 넓은 연령층에게 선호되며 최근 화제성이 계속해서 높아지고 있는 모델입니다.'
    ,'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/jimin_popularity_sns.png','https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/jimin_popularity_search.png','https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/jimin_popularity_brand.png'),
    (3,3,'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/goeun_popularity.png','김고은은 최근 개봉작 “파묘"로 큰 인기를 얻고 있으며 2030에게 연기력을 인정받으며 화제성이 높은 배우입니다.'
    ,'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/goeun_popularity_sns.png','https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/goeun_popularity_search.png','https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/goeun_popularity_brand.png');

-- 모델 화제성 선호 성별
INSERT INTO  soullive.model_popular_gender (gender_id, model_popularity_id, gender_type)
values
    ('1','1','MALE'),
    ('2','1','FEMALE'),

    ('3','2','MALE'),
    ('4','2','FEMALE'),

    ('5','3','MALE'),
    ('6','3','FEMALE');

-- 모델 화제성 선호연령대
INSERT INTO  soullive.model_popular_age (age_id, model_popularity_id,age_type)
values
    (1,1,'THIRTY'),
    (2,1,'FORTY'),
    (3,1,'FIFTY'),

    (4,2,'TWENTY'),
    (5,2,'THIRTY'),
    (6,2,'FORTY'),

    (7,3,'TWENTY'),
    (8,3,'THIRTY');

-- 모델 예정 주요 활동
INSERT INTO  soullive.model_scheduled_work (model_scheduled_work_id,image_url,model_popularity_id,year,category,title,is_main_actor,genre)
values
    (1,'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/heeae_scheduled_work1.png', 1, 2024, '방영 예정 영화','돌풍',true,'드라마'),
    (2,'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/heeae_scheduled_work2.png', 1, 2024, '방영 예정 영화','보통의 가족',true,'드라마'),

    (3,'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/jimin_scheduled_work1.png', 2, 2024, '방영 예정 드라마','인사하는 사이',true,'휴먼'),

    (4,'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/goeun_scheduled_work1.png', 3, 2024, '방영 예정 영화','대도시의 사랑법',true,'로맨스'),
    (5,'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/goeun_scheduled_work2.png', 3, 2024, '방영 예정 드라마','은중과 상연',true,'로맨스'),
    (6,'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/goeun_scheduled_work1.png', 3, 2024, '방영 예정 드라마','자백의 대가',true,'가족');

-- 모델 부정이슈
INSERT INTO  soullive.model_issue (model_issue_id, model_id,  score_url,  ai_comment,crime)
VALUES
    (1, 1, 'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/heeae_badissue.png', '2020년에 처음 알려진 김희애 남편의 횔령 혐의 피소가 있지만 사건의 전말이 정확하지 않고 김희애 배우 본인의 문제가 아니었기에 논란이 크지 않았습니다.', 0),
    (2, 2, 'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/jimin_badissue.png', '한지민은 데뷔 이래로 큰 논란이나 사건이 없었으며 대중들에게 줄곧 바른 이미지를 유지해왔습니다.', 0),
    (3, 3, 'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/goeun_badissue.png', '김고은은 범죄이력이 없으며 두드러지는 사건사고가 없었기 때문에 부정적인 이슈를 일으킬 가능성이 낮습니다.', 0);

--모델 부정이슈 뉴스
INSERT INTO  soullive.model_news (model_news_id, model_issue_id, company, news_date,  title  ,news_url)
VALUES
    (1, 1, '살구뉴스', '2022-12-18', '“잘나가다 남편 때문에" 김희애 남편, 회사 논란 밝혀지자 모두 경악', 'https://www.salgoonews.com/news/articleView.html?idxno=25726'),
    (2, 1, '톱스타뉴스', '2022-08-05', '"부부의 세계" 김희애, 드라마 남편과 실제 남편 이찬진의 오버랩횡령 혐의 논란', 'https://www.topstarnews.net/news/articleView.html?idxno=773836'),
    (3, 1, '스포츠동아', '2022-08-05', '"김희애 남편" 이찬진 전 포티스 대표, 수십억 횡령 혐의 피소', 'https://sports.donga.com/article/all/20200429/100861465/2'),
    (4, 2, 'The fact', '2023-08-19', '한지민의 ''힙하게'', ''성추행 논란'' 완전히 못 지운 찜찜한 출발[TF초점]', 'https://www.topstarnews.net/news/articleView.html?idxno=773836'),
    (5, 2, '금강일보', '2022-08-05', '이민기·한지민 주연 ‘힙하게’, 캐릭터 컨셉 논란', 'https://sports.donga.com/article/all/20200429/100861465/2'),
    (6, 3, '톱스타뉴스', '2023-08-19', '"수지도 5만 원인데”...배우 김고은,  팬미팅 가격 고가 논란', 'https://www.topstarnews.net/news/articleView.html?idxno=773836'),
    (7, 3, '국제신문', '2019-05-05', '김고은 측 ''인터뷰 논란 악플 경고글'' 돌연 삭제... 이유는?', 'https://sports.donga.com/article/all/20200429/100861465/2');


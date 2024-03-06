
-- 모델1 김희애
INSERT INTO soullive.model (model_id, model_name, birth, age, job, info, agency, ai_rate, image_url)
VALUES (1, '김희애', '1967-04-23', '57세', '텔런트/영화배우', '', 'YG 엔터테인먼트', 4.0, 'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/heeae_profile.png');

-- INSERT INTO soullive.model_introduction (model_id, model_introduction_id) VALUES (1, 1);

-- 모델1 김희애 모델소개
INSERT INTO soullive.model_image_keyword (model_image_keyword_id, model_id, keyword)
VALUES
    (1, 1, '#세련됨'),
    (2, 1, '#프로페셔널'),
    (3, 1, '#대중에게 친숙한'),
    (4, 1, '#우아한'),
    (5, 1, '#프리미엄'),
    (6, 1, '#럭셔리함'),
    (7, 1, '#신뢰감');

INSERT INTO soullive.model_recent_work (model_recent_work_id, `year`, model_id, category, genre, image_url, `role`, title)
VALUES
    (1, 2020, 1, '드라마', '가족, 멜로', 'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/heeae_recentwork1.png', '지선우역 (주연)', '부부의 세계'),
    (2, 2023, 1, '드라마', '드라마, 정치', 'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/heeae_recentwork2.png', '황도희역 (주연)', '퀸메이커'),
    (3, 2024, 1, '영화', '범죄', 'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/heeae_recentwork3.png', '심은조역 (주연)', '데드맨');

INSERT INTO soullive.model_recent_advertisement (model_recent_advertisement_id, `year`, model_id, brand, image_url)
VALUES
    (1, 2019, 1, 'LG 프라엘', 'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/heeae_recentadvertisement1.png'),
    (2, 2021, 1, '트렌비', 'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/heeae_recentadvertisement2.png'),
    (3, 2024, 1, '우리은행 투체어스', 'https://soullive-bucket.s3.ap-northeast-2.amazonaws.com/heeae_recentadvertisement3.png');


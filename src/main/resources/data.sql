-- git 에는 soullive로 해야함
INSERT INTO soullive.user (user_id, password, phone_number) VALUES (1, 'password', '010-0000-0000');
INSERT INTO soullive.model (model_id, model_name, birth, age, job, info, agency, ai_rate) VALUES (1,'김희애', '1967-04-23','56세','텔런트/영화배우','','YG 엔터테인먼트',4.0);
INSERT INTO soullive.model_popularity (model_popularity_id,model_id,score_url,ai_comment,sns_url,search_url,brand_score_url) values (1,1,null,'최근 화제성에서는 다소 약한 모습을 보여주고 있지만 3040 남녀 모두에게 높은 인지도를 갖고 있고 앞으로 2개의 주연 활동을 앞두고 있어 더 큰 화제성을 갖을 것으로 예상됩니다.',null,null,null);
INSERT INTO soullive.model_popular_gender (gender_id, model_popularity_id, gender_type) values ('1','1','MALE');
INSERT INTO soullive.model_popular_gender (gender_id, model_popularity_id, gender_type) values ('2','1','FEMALE');
INSERT INTO soullive.model_popular_age (age_id, model_popularity_id,age_type) values (1,1,'THIRTY');
INSERT INTO soullive.model_popular_age (age_id, model_popularity_id,age_type) values (2,1,'FORTY');
INSERT INTO soullive.model_popular_age (age_id, model_popularity_id,age_type) values (3,1,'FIFTY');
INSERT INTO soullive.model_scheduled_work (model_scheduled_work_id,image_url,model_popularity_id,year,category,title,is_main_actor,genre) values (1,null, 1, 2024, '방영 예정 영화','돌풍',true,'공포');
INSERT INTO soullive.model_scheduled_work (model_scheduled_work_id,image_url,model_popularity_id,year,category,title,is_main_actor,genre) values (2,null, 1, 2024, '방영 예정 영화','보통의 가족',true,'공포');
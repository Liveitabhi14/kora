--select * from pg_tables where schemaname='public';
-- Populate CATEGORY table
Insert into category(cat_name) values ('Maths'), ('Tech'), ('Science'), ('History'), ('Politics'), ('Relationship');

-- Populate EVENT table
Insert into event (event_type) values ('Question posted'), ('Answer posted');

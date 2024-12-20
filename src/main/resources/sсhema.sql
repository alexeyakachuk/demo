--DROP TABLE IF NOT EXISTS users, training_user_program, training_program, exercise CASCADE;
--
--CREATE TABLE users IF NOT EXISTS (
--  id SERIAL PRIMARY KEY,
--  name VARCHAR(200),
--  surname VARCHAR(200),
--  age INTEGER,
--  email VARCHAR(200),
--  login VARCHAR(200));
--
--CREATE TABLE IF NOT EXISTS training_user_program (
--  user_id BEGIN REFERENCES users(id),
--  training_programs_id INTEGER REFERENCES training_program(id));
--
--CREATE TABLE NOT EXISTS training_program (
--  id BEGIN PRIMARY KEY,
--  exercise_id INTEGER REFERENCES exercise(id)) ON DELETE CASCADE;
--
--CREATE TABLE NOT EXISTS exercise (
--  id INTEGER PRIMARY KEY,
--  name VARCHAR(200),
--  type VARCHAR(200),
--  description TEXT);

---- Удаляем таблицы, если они существуют
--  DROP TABLE IF EXISTS training_user_program;
--  DROP TABLE IF EXISTS training_program;
--  DROP TABLE IF EXISTS exercise;
--  DROP TABLE IF EXISTS users;

--  -- Создаем таблицу exercise
--  CREATE TABLE exercise (
--    id BIGINT AUTO_INCREMENT PRIMARY KEY,
--    name VARCHAR(200),
--    type VARCHAR(200),
--    description TEXT
--  );
--
--  -- Создаем таблицу training_program
--  CREATE TABLE training_program (
--    id BIGINT AUTO_INCREMENT PRIMARY KEY,
--    exercise_id BIGINT REFERENCES exercise(id)
--  );
--
--  -- Создаем таблицу users
--  CREATE TABLE users (
--    id BIGINT AUTO_INCREMENT PRIMARY KEY,
--    name VARCHAR(200),
--    surname VARCHAR(200),
--    age INTEGER,
--    email VARCHAR(200),
--    login VARCHAR(200)
--  );
--
--  -- Создаем таблицу training_user_program
--  CREATE TABLE training_user_program (
--    user_id BIGINT REFERENCES users(id),
--    training_programs_id BIGINT REFERENCES training_program(id)
--  );


-- Удаляем таблицы, если они существуют
DROP TABLE IF EXISTS training_user_program;
DROP TABLE IF EXISTS training_program;
DROP TABLE IF EXISTS exercise;
DROP TABLE IF EXISTS users;

-- Создаем таблицу exercise
CREATE TABLE IF NOT EXISTS exercise (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(200),
    type VARCHAR(200),
    description TEXT
);

-- Создаем таблицу training_program
CREATE TABLE IF NOT EXISTS training_program (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    exercise_id BIGINT,
    FOREIGN KEY (exercise_id) REFERENCES exercise(id) ON DELETE CASCADE
);

-- Создаем таблицу users
CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(200),
    surname VARCHAR(200),
    age INTEGER,
    email VARCHAR(200),
    login VARCHAR(200)
);

-- Создаем таблицу training_user_program
CREATE TABLE IF NOT EXISTS training_user_program (
    user_id BIGINT,
    training_program_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (training_program_id) REFERENCES training_program(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS instructors (
    instructor_id   SERIAL PRIMARY KEY,
    instructor_name VARCHAR(40) NOT NULL,
    email VARCHAR(40) NOT NULL
    );

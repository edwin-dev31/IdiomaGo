CREATE TABLE IF NOT EXISTS language (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    code VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS word (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS category (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS word_translation (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    word_id BIGINT NOT NULL,
    language_id BIGINT NOT NULL,
    category_id BIGINT,
    translated_word VARCHAR(255) NOT NULL,
    translated_example TEXT,
    translated_description TEXT,
    image_url VARCHAR(255),
    audio_url VARCHAR(255),
    visibility VARCHAR(10) NOT NULL DEFAULT 'PUBLIC',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE SET NULL,
    FOREIGN KEY (word_id) REFERENCES word(id) ON DELETE CASCADE,
    FOREIGN KEY (language_id) REFERENCES language(id) ON DELETE CASCADE,
    FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE SET NULL
);


CREATE TABLE IF NOT EXISTS favorites (
    user_id BIGINT NOT NULL,
    word_translation_id BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (user_id, word_translation_id),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (word_translation_id) REFERENCES word_translation(id) ON DELETE CASCADE
);

CREATE UNIQUE INDEX uq_word_language ON word_translation (word_id, language_id);

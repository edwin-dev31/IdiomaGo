DROP INDEX IF EXISTS uq_word_language;

CREATE UNIQUE INDEX uq_user_word_language
ON word_translation (user_id, word_id, language_id);

CREATE TABLE IF NOT EXISTS reaction (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    word_translation_id BIGINT NOT NULL,
    emoji VARCHAR(10) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (word_translation_id) REFERENCES word_translation(id) ON DELETE CASCADE
);

INSERT INTO reaction (user_id, word_translation_id, emoji)
VALUES
  (1, 1, '🔥'),
  (1, 2, '💯'),
  (1, 3, '👍'),
  (1, 4, '❤️'),
  (1, 5, '❤️');
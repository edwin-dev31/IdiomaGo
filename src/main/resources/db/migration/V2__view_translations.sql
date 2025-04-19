CREATE VIEW IF NOT EXISTS view_translations AS
SELECT
    wt.id AS translation_id,
    w.id AS word_id,
    w.name AS original_word,
    l.id AS language_id,
    l.code AS language_code,
    wt.translated_word,
    wt.translated_example,
    wt.translated_description,
    wt.image_url,
    wt.audio_url,
    wt.created_at
FROM word_translation wt
JOIN word w ON wt.word_id = w.id
JOIN language l ON wt.language_id = l.id;

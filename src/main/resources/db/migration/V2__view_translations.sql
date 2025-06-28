CREATE OR REPLACE VIEW view_translations AS
SELECT
    w.id AS word_id,
    wt.user_id,
    w.name AS original_word,
    l.id AS language_id,
    l.name AS language_name,
    l.code AS language_code,
    wt.id AS word_translation_id,
    wt.translated_word,
    wt.translated_example,
    wt.translated_description,
    wt.image_url,
    wt.audio_url,
    wt.created_at,
    wt.visibility,
    c.id AS category_id,
    c.name AS category_name
FROM word_translation wt
JOIN word w ON wt.word_id = w.id
JOIN language l ON wt.language_id = l.id
LEFT JOIN category c ON wt.category_id = c.id;

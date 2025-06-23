CREATE VIEW view_translations AS
SELECT
    w.id AS word_id,
    w.name AS original_word,
    l.id AS language_id,
    l.name AS language_name,
    l.code AS language_code,
    wt.id AS word_Translation_Id,
    wt.translated_word,
    wt.translated_example,
    wt.translated_description,
    wt.image_url,
    wt.audio_url,
    wt.created_at
FROM word_translation wt
JOIN word w ON wt.word_id = w.id
JOIN language l ON wt.language_id = l.id;

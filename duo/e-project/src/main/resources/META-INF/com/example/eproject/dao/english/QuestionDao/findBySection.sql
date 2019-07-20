select
e.id as id, e.japanese as japanese
from
english e
  join
  section s
    on
  e.id = s.english_id
where
s.section_num = /*section*/1;
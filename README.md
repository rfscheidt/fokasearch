# fokasearch

### Reference Documentation
Este projeto é para testes no Elasticsearch 

### Guides
Subir o Elasticsearch com docker

docker run -p 9200:9200 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.10.0

*** Rodar os testes unitários (LoadIndexTest) para carregar os indices

*** Rodar testes com postman: POST http://localhost:9200/productindex/_search
**** {"from":3,"size":6,"query":{"bool":{"must":[{"query_string":{"query":"Name","fields":["name^1.0"],"type":"best_fields","default_operator":"and","max_determinized_states":10000,"enable_position_increments":true,"fuzziness":"AUTO","fuzzy_prefix_length":0,"fuzzy_max_expansions":50,"phrase_slop":0,"escape":false,"auto_generate_synonyms_phrase_query":true,"fuzzy_transpositions":true,"boost":1.0}}],"adjust_pure_negative":true,"boost":1.0}},"version":true}

*** http://localhost:8080/search para buscar no indice. Autocomplete included.



# Spark integrácia s ďalšími technologiami (elasticsearch, kubernetes)

### Autori: 
    - Viliam Alakša
    - Juraj Budai
    - Martin Kubečka
    - Juraj Lapčák
    - Ľubomír Ševčík

### [Dokumentacia](Dokumentacia.pdf)

### [Prezentacia](Spark%20integrácia%20s%20ďalšími%20technológiami%20%20(Elasticsearch,%20Kubernetes).pptx )
----
## Apache Spark s Elasticsearch
- potrebna lokalna Elasticsearch (v 6.0.0 recommended) instancia na localhost:9200
- potrebna Java 8/11 a vyssie 

## Kubernetes so Spark
- vsetky tutorialy potrebne k instalacii su v [req.txt](kubernetes/req.txt), ale podrobnejsie postupy a mozne problemy s instalaciou su popisane v [Dokumentacia](Dokumentacia.pdf)
- Spark 3.1.1
- Kubernetes v1.25.2
- minikube v1.28.0
---
## Otazka ku skuske
Aký typ architektúry používa Docker?

- [ ] Peer-to-peer
- [x] Klient-Server
- [ ] Event-driven
- [ ] REST



### Spotify dataset
charts_smaller.csv is a modified dataset of a complete dataset of all the "Top 200" and "Viral 50" chart published globally by Spotify. Available at Kaggle: https://www.kaggle.com/datasets/dhruvildave/spotify-charts

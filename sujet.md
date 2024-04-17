# Sujet

On s’intéresse à la gestion des réservations de places dans une grande salle de spectacles, Le Patio, à Melun. Monsieur Malraux, le directeur de la salle, vous a demandé de développer une application de gestion des réservations.

Il vous a expliqué l’organisation de cette gestion qui est la suivante.

La salle est divisée en zones (orchestre, balcon, loges gauches et loges droites) comme indiqué dans le plan fourni en annexe 1.

Un fauteuil est repéré, relativement à sa zone, par une lettre qui représente la rangée et par un numéro de fauteuil. Un spectacle peut être de catégorie A, B ou C (selon la notoriété de l’artiste). La catégorie du spectacle est un des facteurs qui déterminent le prix du spectacle. Il dépend aussi d’une gamme de prix qui est fonction de la place occupée par un fauteuil dans la salle. A une zone correspond une gamme de prix.

Ce prix au tarif adultes dépend d’autres facteurs que nous ne détaillerons pas ici. Le prix d’un spectacle est fixé par Mr Malraux. Il est le même pour toutes les représentations d’un spectacle donné (pour une même zone et une même catégorie de spectateurs).

## Gestion des catégories et tarifs de spectateurs

Il existe plusieurs catégories de spectateurs :

- Jeune de moins de 25 ans,
- Sénior de plus de 65 ans,
- Abonné qui assiste à au moins 3 spectacles par an,
- Groupe d’au moins 20 adultes,
- Adulte qui ne fait partie d’aucune autre catégorie.

*Dans les explications qui suivent, le terme ‘client’ correspond à l’acheteur des billets. Il peut être remplacé par ‘spectateur’ s’il achète des billets pour lui-même. Un ‘spectateur’ n’est pas forcément celui qui a acheté les billets.*

C’est au spectateur de choisir la catégorie à laquelle il veut appartenir si sa situation lui permet de faire partie de plusieurs d’entre elles.

Les spectateurs peuvent choisir une carte d’abonnement gérée de la manière suivante. Dans les explications qui suivent, le tarif adultes est celui sans abonnement pour des adultes.

L’abonnement, c’est à la fois très simple et très avantageux. **Par défaut, le client n’est pas abonné. Il choisit un même jour au moins 3 spectacles différents pour une saison par adulte pour être abonné. Il bénéficie alors de 30% de réduction sur le tarif adultes pour son billet pour chacun de ces spectacles. Il reçoit alors ses billets.**

**Rien ne l’empêche d’acheter des billets pour d’autres personnes qui ne seront pas abonnées. Une personne qui veut être abonnée doit se présenter elle-même au guichet et montrer sa carte d’identité.**

**Si un abonné achète un billet pour d’autres spectacles plus tard dans la saison, il ne bénéficiera pas du tarif ‘Abonnés’. L’abonnement est nominatif. Il suppose que les informations sur l’identité de chaque abonné sont saisies. Il ne pourra donc pas demander un autre tarif ‘Abonnés’ en cours de saison.**

Afin de faciliter l’accès aux familles, le « tarif jeune » permet à tous les jeunes de bénéficier d’un tarif préférentiel sur tous les spectacles de la saison sans obligation de s’abonner. Ce tarif préférentiel correspond à une réduction de 30 % sur le tarif adultes.

Sans abonnement, les seniors bénéficient d’une réduction de 25% sur le tarif adultes.

Le guichetier fait confiance au client au sujet de l’âge des spectateurs pour qui il achète des billets. Une vérification peut être faite à l’entrée de la salle avant le spectacle.

Il est appliqué une réduction de 15 % sur le tarif adultes par billet aux groupes d’au moins 20 adultes.

Le taux de TVA est de 2,10 %. Le tarif HT sera indiqué sur les factures, pas sur les billets qui indiqueront le prix TTC.

## Gestion des spectacles et des représentations

**Un spectacle est identifié par un nom.** Un même spectacle peut donner lieu à plusieurs
représentations.

Mr Malraux doit pouvoir gérer un tarif adulte par zone pour chaque spectacle. Les tarifs
réduits en sont déductibles. Il doit donc pouvoir créer, modifier, consulter la liste des tarifs
de chaque spectacle et afficher la liste des tarifs de tous les spectacles triés par catégorie.

**Il existe au maximum deux représentations par jour pour un même spectacle. Mr Malraux doit pouvoir créer un planning en début de saison, le modifier si besoin, l’afficher.**

**Le logiciel doit pouvoir indiquer pour chaque spectacle ses date et heure de début de représentation (qui varient d’un spectacle à l’autre), le nombre maximum de spectateurs par spectacle, la catégorie du spectacle, sa durée, son genre (le théâtre, la musique « live », la danse, les arts du cirque, les arts de la marionnette et l'opéra).**

Chaque spectacle doit pouvoir être créé, modifié, consulté, supprimé. S’il est supprimé, ses tarifs le sont au même moment.

Mr Malraux veut pouvoir trier le planning par ordre chronologique, ou par genre, ou par catégorie. Il veut aussi pouvoir le filtrer sur ces mêmes critères (entre une date de début et une date de fin, ou un genre et une période donnés, ou une catégorie et une péride données).

## Gestion des réservations, des clients et des spectateurs

### Gestion de la saisie des réservations

La gestion des réservations de billets de spectacles implique plusieurs étapes pour assurer un processus efficace (cf annexe 2).

Tout d'abord, il faut mettre en place la réservation, que ce soit par téléphone ou au guichet. Une réservation concerne une seule représentation. Tous les billets d’une réservation ne correspondent qu’à une seule zone. La réservation doit être conviviale et facile à utiliser, permettant au guichetier de sélectionner par le logiciel :

1. une représentation,
2. la zone dans laquelle le client veut être (c’est-à-dire la gamme de prix choisie, choix1)
3. la catégorie de spectateurs pour laquelle des billets seront achetés
4. éventuellement les places qui conviennent (rangée et numéro de place avec rangée, choix 2).

### Attribution des places

Si le guichetier peut satisfaire le choix du client, il lui attribue les places pour une réservation. Si le choix du client ne peut être satisfait, le guichetier en informe le client et attend les nouvelles instructions du client (qui peuvent être de nouveaux souhaits ou un abandon). En cas d’abandon, on n’enregistre pas les informations saisies. Une fois le client satisfait par la proposition, la réservation est enregistrée et les billets imprimés.

## Gestion des clients et des spectateurs

Une fois ces informations sur la réservation saisies, le logiciel doit enregistrer les informations sur l’identité du client, les détails de la réservation, ainsi que le paiement effectué. Mr Malraux souhaite, en effet, conserver l’identité de chaque client (nom, prénom, adresse postale complète, numéro de téléphone fixe ou portable, adresse mail). Un numéro de client est attribué automatiquement par le logiciel lors de la création de la fiche du client, c’est-à-dire à la 1ère réservation. Seule l’identité du client est enregistrée.

**Pour une réservation, Mr Malraux veut donc connaître l’identité de l’acheteur et celles de tous les spectateurs qui sont abonnés.**

### Paiement

Le mode de paiement peut être chèque, chèque vacances, carte bancaire, ou espèces. Le paiement correspond toujours à la totalité du montant de la réservation et est enregistré à la date de la réservation.

### Confirmation de réservation

Enfin, il est important de mettre en place un système de confirmation de réservation. Les clients doivent recevoir une confirmation de leur réservation, de préférence par e-mail ou par SMS, qui récapitule tous les détails de leur achat. Cette confirmation doit leur être envoyée dès la réservation effectuée (on conserve la date d’envoi de la confirmation).

### Facturation

Toute réservation donne lieu à la création d’une facture qui peut être imprimée sur demande (cf annexe 4) dès la réservation. Le numéro de facture est composé de la date de facturation au format AAAMMJJ suivie d’un numéro de facture qui s’incrémente de 1 à chaque facture établie depuis le 1er janvier de l’année en cours. Elle est établie au nom du client qui réserve.

### Synthèse

A ce stade, les détails de la réservation sont donc :

- le numéro de client,
- la date de la réservation,
- celle d’envoi de la confirmation,
- un numéro de réservation attribué automatiquement par le logiciel,
- le mode de paiement
- la gamme de prix
- les fauteuils attribués (zone, rang et numéro de places)
- le numéro de facture.

Mr Malraux ne souhaite pas pouvoir modifier une réservation.

Gestion de la disponibilité des places La disponibilité des places doit être mise à jour en temps réel sur le plan de la salle pour éviter les doubles réservations. Ainsi, dès qu'une réservation est effectuée, le nombre de places restantes doit être automatiquement mis à jour. Si une demande de réservation intervient alors qu’il n’y a pas assez de places disponibles pour le nombre de personnes voulu, la demande de réservation est rejetée.

## Gestion des annulations de représentations

Il est possible qu’une représentation (voire toutes les représentations d’un spectacle) soit annulée à la demande de l’artiste concerné. Dans ce cas, un mail doit être envoyé à chaque client qui a déjà réservé et un remboursement des billets déjà payés est effectué sous 8 jours.

Mr Malraux souhaite avoir une liste des représentations annulées chaque saison et pour chaque représentation annulée :

- date et heure de début prévues
- nom de l’artiste
- nom du spectacle
- numéros de réservations
- dates de remboursement
- nombre de billets qui ont dû être annulés par réservation et au total
- montant remboursé par réservation et au total pour la représentation concernée.

Cette liste doit pouvoir être triée par ordre chronologique des représentations ou par artiste.

## Gestion des demandes d’annulation de la part des clients

Si la demande d’annulation intervient moins de 7 jours (inclus) avant la date de la représentation, l’annulation est refusée. Le client conserve les billets (qui ne sont pas nominatifs). Aucun remboursement n’est effectué.

Si la demande intervient plus de 7 jours avant la représentation, elle est acceptée. Mr Malraux doit effectuer un remboursement total du prix de la réservation annulée à condition que les billets vendus lui soient rapportés. La date de la demande, celle du remboursement, le numéro de la réservation et le numéro de chaque billet retourné sont enregistrés. Il veut avoir par saison la liste des annulations effectuées et acceptées qui indique : le numéro du client qui a annulé, son nom, le numéro de réservation, le nom du spectacle, la date et l’heure de la représentation et le nombre de billets retournés, le montant total remboursé au client par représentation, la date de remboursement, le montant total remboursé par saison.

Lors de l’enregistrement de l’annulation, le guichetier vérifie que tous les billets de la réservation sont retournés. Si oui, il rembourse le montant total de la réservation. Sinon, il ne rembourse que le montant qui correspond aux billets retournés. Les places qui correspondent aux billets annulés deviennent disponibles pour la représentation.

## Affichage de divers états et statistiques

Mr Malraux veut obtenir :

- la liste des réservations non annulées qui comportera :
    - le nom du spectacle, les dates et heures de début de ses représentations 5 IUT de Lannion/Département informatique 2023-2024
    - le nombre de réservations de chaque représentation avec pour chacune le nombre de billets vendus et le montant total des réservations
    - le nombre de places encore disponibles à la date de l’affichage.

- la liste des réservations annulées à la demande du client qui comportera :
    - le nom du client et son numéro
    - le nom du spectacle, la date et l’heure de début de la représentation concernée
    - la date de demande d’annulation
    - le nombre de billets vendus, le nombre de billets retournés et le montant total du remboursement de la réservation.

Cette liste doit pouvoir être triée par nom de spectacle, ou par date de représentation, ou par date d’annulation, ou par numéro de client et ordre chronologique de date de représentation.

- la liste des représentations annulées par l’artiste qui comportera :
    - le nom de l’artiste
    - le nom du spectacle, la date et l’heure de début de la représentation concernée
    - la date d’annulation
    - le nombre de billets vendus, et le montant total du remboursement que Mr Malraux a dû faire aux clients concernés par l’annulation.

Cette liste doit pouvoir être triée par ordre chronologique des représentations ou par artiste.

Mr Malraux veut obtenir les statistiques suivantes sous forme d’un tableau où apparaîtront :

- la saison
- le nom de l’artiste
- le nom du spectacle
- le nombre de représentations de chaque spectacle
- le nombre de billets vendus par représentation et le total par spectacle.

Il veut aussi connaître par saison :

- le nombre total de billets vendus au cours de la saison et le CA de la saison
- le nombre de représentations par artiste
- le CA par spectacle, par représentation, par artiste.

Il veut pouvoir filtrer et trier ces deux rapports sur :

- le nom du spectacle OU
- le nom de l’artiste.

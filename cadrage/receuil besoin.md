# Recueil du besoin

## Besoins fonctionnels

1. Gestion des catégories et tarifs de spectateurs :
   - Définir les catégories de spectateurs (jeune, sénior, abonné, groupe, adulte).
   - Définir les tarif adultes fonction de la zone et de la catégorie de la représentation au début de chaque saison.
   - Gérer les abonnements et les réductions associées.
   - Appliquer la TVA aux tarifs.

2. Gestion des spectacles et des représentations :
   - Créer, modifier, consulter et supprimer les spectacles.
   - Créer, modifier et afficher le planning des représentations.
   - Enregistrer les informations sur chaque spectacle (nom, Date et heure de début, nombre maximum de spectateurs, catégorie, durée, genre).
   - Trier et filtrer le planning par ordre chronologique, genre ou catégorie.

3. Gestion des réservations, des clients et des spectateurs :
   - Enregistrer les réservations avec les détails correspondants (numéro de client, date de réservation, numéro de réservation, mode de paiement, gamme de prix, fauteuils, numéro de facture).
   - Attribuer les places en fonction des choix du client et vérifier la disponibilité.
   - Gérer les paiements et les factures.
   - Envoyer une confirmation de réservation par e-mail ou SMS.

4. Gestion de la disponibilité des places :
   - Mettre à jour la disponibilité des places.
   - Rejeter les demandes de réservation si le nombre de places disponibles est insuffisant.

5. Gestion des annulations de représentations :
   - Enregistrer les annulations de représentations à la demande de l'artiste.
   - Rembourser les billets déjà payés en cas d'annulation.
   - Générer une liste des représentations annulées avec les détails correspondants.

6. Gestion des demandes d’annulation de la part des clients :
   - Traiter les demandes d'annulation des clients en fonction des conditions d'annulation.
   - Rembourser les billets en cas d'annulation acceptée.
   - Générer une liste des annulations effectuées et acceptées avec les détails correspondants.

7. Affichage de divers états et statistiques :
   - Générer des listes de réservations non annulées, de réservations annulées à la demande du client et de représentations annulées par l'artiste.
   - Fournir des statistiques sur les ventes de billets, le chiffre d'affaires et les représentations par artiste.
   - Filtrer et trier les rapports en fonction du nom du spectacle ou de l'artiste.

todo :

- CRUD des sièges
- créer facture
- crud zone
- gérer le mode de paiement
- afficher tarif

## Besoins non fonctionnels

1. Convivialité :
   - L'application doit être conviviale et facile à utiliser pour le guichetier. Cela signifie que chaque tâche devra prendre moins de 7 clics pour être effectuée.

2. Performance :
   - L'application ne doit pas contenir de délai supérieur à 2 secondes sans barre de progression (limite pour l'ergonomie)

3. Sécurité :
   - L'application et les données doivent uniquement être accessible aux guichetier et à M. Malraux.

## Objectifs

1. Faciliter la gestion des réservations de billets de spectacles pour le personnel de la salle.
2. Améliorer l'expérience des clients en offrant un processus de réservation simple et efficace.
3. Fournir des informations précises et à jour sur les réservations, les représentations et les ventes de billets.

## Contraintes

1. L'application sera utilisée par le personnel de la salle et non par les clients.
2. Les tarifs réduits sont déductibles des tarifs adultes et ne peuvent pas être combinés entre eux.
3. Les abonnements sont nominatifs et limités à un par personne.
4. Les annulations de réservations doivent être effectuées sous 7 jours inclus avant la date de la représentation.
5. Les remboursements doivent être effectués sous 8 jours en cas d'annulation de représentation par l'artiste.

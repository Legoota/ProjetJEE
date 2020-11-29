package dataservice;

import model.Attaque;
import model.Polymon;
import repository.JeeRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@Stateless
@LocalBean
public class AdminDataService {

    JeeRepository repository;

    public AdminDataService() {
        this.repository = new JeeRepository();
    }

    public boolean initializeDatabase() {
        List<Polymon> polymons = new ArrayList<>();
        List<Attaque> attaques = new ArrayList<>();

        Polymon bulbizarre = new Polymon("Polymon_1","Bulbizarre","Bulbizarre est un petit quadrupède vert avec une tête large. Il porte un bulbe sur son dos. Ce dernier lui sert également d'organe de stockage, puisqu’on rapporte notamment qu’en période de sécheresse, il peut survivre plusieurs jours sans manger grâce à l’énergie qui y est accumulée.", 50);
        polymons.add(bulbizarre);

        Polymon salameche = new Polymon("Polymon_2","Salameche","Salamèche est un Polymon bipède et reptilien avec un corps orange tandis que son ventre et la plante de ses pieds sont jaunes. Ses bras et ses jambes sont courts, avec respectivement quatre doigts et trois griffes chacune. Une flamme brûle au bout de la svelte queue de Salamèche, et elle flamboie depuis sa naissance.", 50);
        polymons.add(salameche);

        Polymon carapuce = new Polymon("Polymon_3","Carapuce","Carapuce est une petite tortue bipède de couleur bleue. Il possède une carapace majoritairement brune, jaune pâle au niveau du ventre. Ses yeux sont grands et violacés. Il a une queue avec un motif de spirale à son extrémité. Il possède quatre pattes avec chacune trois doigts.", 50);
        polymons.add(carapuce);

        Polymon pikachu = new Polymon("Polymon_4","Pikachu","Pikachu est un petit Polymon joufflu qui ressemble à un rongeur, au corps recouvert d’un pelage jaune avec deux bandes horizontales brunes dans le dos. Il a une petite bouche, de longues oreilles pointues aux extrémités noires et des yeux marron. Il a sur chacune de ses joues un marquage rouge qui est en réalité une poche contenant de l’électricité.", 60);
        polymons.add(pikachu);

        Polymon goupix = new Polymon("Polymon_5","Goupix","Goupix est un petit Polymon quadrupède à l’allure vulpine. Son pelage est rouge tomette avec un ventre de couleur crème. Il a de grands yeux noisette, des oreilles pointues à l’intérieur brun et un petit museau brun. Le pelage de ses pattes est légèrement plus foncé que sur le reste de son corps et il a de petits coussinets brun clair.", 60);
        polymons.add(goupix);

        Polymon nosferapti = new Polymon("Polymon_6","Nosferapti","Nosferapti est une petite chauve-souris bleu foncé. La membrane de ses ailes est violette, tout comme le creux de ses grandes oreilles. Sa mâchoire possède quatre crocs apparents. Ses membres inférieurs ne sont pas munis de pieds et son visage ne possède pas d'yeux, puisque ce Pokémon utilise des ultrasons pour se déplacer dans l'obscurité des grottes où il vit principalement.", 30);
        polymons.add(nosferapti);

        Polymon miaouss = new Polymon("Polymon_7","Miaouss","Miaouss ressemble à un chat, à la différence qu'il se tient la plupart du temps sur ses deux pattes arrière. Il a le corps beige, le bout des pattes et de la queue marron et les oreilles noires. Sa pièce dorée fixée sur son front a une relative ressemblance avec la Pièce Rune.", 60);
        polymons.add(miaouss);

        Polymon psykokwak = new Polymon("Polymon_8","Psykokwak","Psykokwak a l'allure générale d'un ornithorynque jaune. Il a un bec jaune pâle un peu aplati, les pattes de la même couleur que son bec. Il est souvent pris de migraines, qui lui permettent d'utiliser de puissants pouvoirs psychiques. Malgré ces pouvoirs mentionnés par le Polydex, il n'est pas de type Psy.",60);
        polymons.add(psykokwak);

        Polymon noeunoeuf = new Polymon("Polymon_9","Noeunoeuf","Noeunoeuf est habituellement composé de six entités ressemblant à des œufs avec un visage souvent menaçant. La plupart de ces œufs sont craquelés par endroits, l'un d'eux est ouvert et laisse apparaître son jaune.",60);
        polymons.add(noeunoeuf);

        Polymon insecateur = new Polymon("Polymon_10","Insecateur","Insécateur est inspiré de la mante religieuse verte. Bipède, il se tient sur deux larges pattes équipées de trois griffes. Il possède deux paires d'ailes, et deux grandes faux en guise de bras.",80);
        polymons.add(insecateur);

        Polymon scarabrute = new Polymon("Polymon_11","Scarabrute","Scarabrute ressemble à un scarabée marron bipède qui, au lieu d'avoir des mandibules, possède deux cornes avec plusieurs petits pics sur sa tête. Il a un regard agressif et possède une bouche à dix dents (cinq en vertical de chaque côté). Il a de petits bras et trois doigts griffus et possède de grands pieds avec trois orteils (deux devant et un derrière).",80);
        polymons.add(scarabrute);

        Polymon magmar = new Polymon("Polymon_12","Magmar","Magmar a le corps parsemé de motifs de flammes orange et jaune. Ses mains sont dotées de griffes acérées à leurs extrémités, tout comme ses pieds. Deux flammes ardentes crépitent sur sa tête et sa queue se termine par une flamme. Son cou et ses jambes sont noirs.",80);
        polymons.add(magmar);

        Polymon leviator = new Polymon("Polymon_13","Léviator","Léviator est un Polymon à l'allure serpentine avec un long corps principalement bleu à l'exception de son ventre et de quelques une de ses écailles qui sont jaune pâle. Sa bouche aux lèvres jaunes est très large et révèle, une fois grande ouverte, quatre dents pointues. Il a un barbillon et une petite nageoire blanche sur chaque côté de la tête. Il a de petits yeux rouges, une crête bleu foncé sur la tête et quatre nageoires dorsales blanches.",90);
        polymons.add(leviator);

        Polymon ptera = new Polymon("Polymon_14","Ptéra","Ptéra ressemble à un grand reptile carnassier gris-violet volant grâce à des membranes tendues entre ses doigts, proche du ptérodactyle dont il tire son nom. Ptéra est constitué de roche (dont le poids ne semble étonnement pas l'empêcher de voler), d'où sa classification en Polymon de base de type Roche et Vol.",80);
        polymons.add(ptera);

        Polymon dracolosse = new Polymon("Polymon_15","Dracolosse","Dracolosse est un Polymon bipède ressemblant à un dragon à la peau jaune foncé. Il est grand, assez costaud, a des yeux de couleur vert kaki, et il possède deux petites ailes bleu vert dans le dos lui permettant de voler. Il possède une corne et deux antennes blanches sur sa tête, trois griffes sur ses mains et ses pieds et une queue.",120);
        polymons.add(dracolosse);

        Polymon rhinoferos = new Polymon("Polymon_16","Rhinoféros","Rhinoféros ressemble à un rhinocéros redressé sur ses pattes arrière. Il possède une unique corne sur le museau, qui a un motif en spirale, tel celui d'une foreuse. Il a une longue queue avec les mêmes motifs que sur sa corne.",110);
        polymons.add(rhinoferos);

        Polymon aquali = new Polymon("Polymon_17","Aquali","Aquali est un Polymon qui partage des traits physiques avec des animaux marins et terrestres. Il est quadrupède avec trois petits orteils à chaque pied et un coussinet bleu foncé sur ses pattes postérieures. Le corps d'Aquali est bleu clair avec une marque bleu foncé sur la tête et une arête sur son dos.",100);
        polymons.add(aquali);

        Polymon sulfura = new Polymon("Polymon_18","Sulfura","Sulfura est un grand oiseau de couleur jaune orangé. Il possède un long bec marron, et est reconnaissable à ses ailes, crête et panache enflammés rouge et rose. Il a également une queue enflammée rouge et rose. Il a des serres marron à quatre orteils (un derrière et trois devant). Il a des yeux triangulaires noirs.",130);
        polymons.add(sulfura);

        Polymon mew = new Polymon("Polymon_19","Mew","Peu de choses sont connues à son propos. Il est dit qu'autrefois, les Mew étaient nombreux, mais tous auraient disparu sauf un. Ce Polymon mythique peut apprendre la plupart des capacités, c'est pour cela que certains pensent qu'il est l'ancêtre de tous les Polymon. Par ailleurs, Mew est connu pour avoir été cloné afin de créer Mewtwo.",140);
        polymons.add(mew);

        Polymon mewtwo = new Polymon("Polymon_20","Mewtwo","Comme Mewtwo a été créé à partir de Mew, il est également à mi-chemin entre le chat (pour la tête) et la gerboise (pour le reste du corps), à la différence qu'il mesure 2 mètres et a des membres plus longs que ceux de Mew, lui donnant une apparence presque humanoïde. Il se déplace la plupart du temps en lévitant. Mewtwo est un Polymon principalement mauve (ou blanc selon les versions). Il possède une longue queue violette qui remonte jusqu'au bas de son ventre.",150);
        polymons.add(mewtwo);

        Attaque acide = new Attaque("Attaque_1", "Acide",20);
        attaques.add(acide);

        Attaque belier = new Attaque("Attaque_2", "Bélier",30);
        attaques.add(belier);

        Attaque cageEclair = new Attaque("Attaque_3", "Cage-Eclair",40);
        attaques.add(cageEclair);

        Attaque cascade = new Attaque("Attaque_4", "Cascade",30);
        attaques.add(cascade);

        Attaque coupDeBoule = new Attaque("Attaque_5", "Coup de Boule",25);
        attaques.add(coupDeBoule);

        Attaque deflagration = new Attaque("Attaque_6", "Déflagration",50);
        attaques.add(deflagration);

        Attaque eclair = new Attaque("Attaque_7", "Éclair",20);
        attaques.add(eclair);

        Attaque ecume = new Attaque("Attaque_8", "Écume",20);
        attaques.add(ecume);

        Attaque frappeAtlas = new Attaque("Attaque_9", "Frappe Atlas",70);
        attaques.add(frappeAtlas);

        Attaque hydrocanon = new Attaque("Attaque_10", "Hydrocanon",70);
        attaques.add(hydrocanon);

        Attaque lanceFlammes = new Attaque("Attaque_11", "Lance-Flammes",60);
        attaques.add(lanceFlammes);

        Attaque sangsue = new Attaque("Attaque_12", "Sangsue",70);
        attaques.add(sangsue);

        Attaque seisme = new Attaque("Attaque_13", "Séisme",100);
        attaques.add(seisme);

        Attaque comete = new Attaque("Attaque_14", "Comète",110);
        attaques.add(comete);

        Attaque ombreNocturne = new Attaque("Attaque_15", "Ombre Nocturne",120);
        attaques.add(ombreNocturne);

        Attaque pique = new Attaque("Attaque_16", "Piqué",80);
        attaques.add(pique);

        Attaque pistoletAEau = new Attaque("Attaque_17", "Pistolet à eau",60);
        attaques.add(pistoletAEau);

        Attaque fouet = new Attaque("Attaque_18", "Fouet",60);
        attaques.add(fouet);

        Attaque jetDePierres = new Attaque("Attaque_19", "Jet de pierres",80);
        attaques.add(jetDePierres);

        Attaque piqure = new Attaque("Attaque_20", "Piqûre",20);
        attaques.add(piqure);

        return repository.initializeDatabase(polymons, attaques);
    }

    public void afficheAllMonstre() {
        List<Polymon> polymons = new ArrayList<>();

        polymons = repository.getAllMonstre();

        for(Polymon polymon : polymons) {
            System.out.println("Le polymon d'id " + polymon.getId() + " s'appelle " + polymon.getNom());
        }
    }
}

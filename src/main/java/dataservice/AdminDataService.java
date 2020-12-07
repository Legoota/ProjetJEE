package dataservice;

import model.Attaque;
import model.Parcours;
import model.Polymon;
import model.Step;
import org.apache.commons.collections.ArrayStack;
import repository.JeeRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe DataService pour les fonctionnalités admin
 */
@Stateless
@LocalBean
public class AdminDataService {

    JeeRepository repository;

    /**
     * Constructeur de la classe AdminDataService
     */
    public AdminDataService() { this.repository = new JeeRepository(); }

    /**
     * Méthode permettant de réaliser l'initialisation de la base de données avec un jeu de valeurs
     * @return <b>True</b> si correctement initialisée, <b>False</b> sinon
     */
    public boolean initializeDatabase() throws FileNotFoundException {
        List<Polymon> polymons = new ArrayList<>();
        List<Attaque> attaques = new ArrayList<>();
        List<Step> steps = new ArrayList<>();
        List<Parcours> parcours = new ArrayList<>();

        Attaque acide = new Attaque("Attaque_1", "Acide",20);
        attaques.add(acide);

        Attaque belier = new Attaque("Attaque_2", "Belier",30);
        attaques.add(belier);

        Attaque cageEclair = new Attaque("Attaque_3", "Cage-Eclair",40);
        attaques.add(cageEclair);

        Attaque cascade = new Attaque("Attaque_4", "Cascade",30);
        attaques.add(cascade);

        Attaque coupDeBoule = new Attaque("Attaque_5", "Coup de Boule",25);
        attaques.add(coupDeBoule);

        Attaque deflagration = new Attaque("Attaque_6", "Deflagration",50);
        attaques.add(deflagration);

        Attaque eclair = new Attaque("Attaque_7", "Eclair",20);
        attaques.add(eclair);

        Attaque ecume = new Attaque("Attaque_8", "Ecume",20);
        attaques.add(ecume);

        Attaque frappeAtlas = new Attaque("Attaque_9", "Frappe Atlas",70);
        attaques.add(frappeAtlas);

        Attaque hydrocanon = new Attaque("Attaque_10", "Hydrocanon",70);
        attaques.add(hydrocanon);

        Attaque lanceFlammes = new Attaque("Attaque_11", "Lance-Flammes",60);
        attaques.add(lanceFlammes);

        Attaque sangsue = new Attaque("Attaque_12", "Sangsue",70);
        attaques.add(sangsue);

        Attaque seisme = new Attaque("Attaque_13", "Seisme",100);
        attaques.add(seisme);

        Attaque comete = new Attaque("Attaque_14", "Comete",110);
        attaques.add(comete);

        Attaque ombreNocturne = new Attaque("Attaque_15", "Ombre Nocturne",120);
        attaques.add(ombreNocturne);

        Attaque pique = new Attaque("Attaque_16", "Pique",80);
        attaques.add(pique);

        Attaque pistoletAEau = new Attaque("Attaque_17", "Pistolet a eau",60);
        attaques.add(pistoletAEau);

        Attaque fouet = new Attaque("Attaque_18", "Fouet",60);
        attaques.add(fouet);

        Attaque jetDePierres = new Attaque("Attaque_19", "Jet de pierres",80);
        attaques.add(jetDePierres);

        Attaque piqure = new Attaque("Attaque_20", "Piqure",20);
        attaques.add(piqure);

        ArrayList<Attaque> bulbizarre_a = new ArrayList<Attaque>() {{add(piqure);add(acide);}};
        Polymon bulbizarre = new Polymon("Polymon_1","Bulbizarre","Bulbizarre est un petit quadrupède vert avec une tête large. Il porte un bulbe sur son dos. Ce dernier lui sert également d'organe de stockage, puisqu’on rapporte notamment qu’en période de sécheresse, il peut survivre plusieurs jours sans manger grâce à l’énergie qui y est accumulée.", 50,bulbizarre_a);
        polymons.add(bulbizarre);

        ArrayList<Attaque> salameche_a = new ArrayList<Attaque>() {{add(deflagration);add(belier);}};
        Polymon salameche = new Polymon("Polymon_2","Salameche","Salamèche est un Polymon bipède et reptilien avec un corps orange tandis que son ventre et la plante de ses pieds sont jaunes. Ses bras et ses jambes sont courts, avec respectivement quatre doigts et trois griffes chacune. Une flamme brûle au bout de la svelte queue de Salamèche, et elle flamboie depuis sa naissance.", 50,salameche_a);
        polymons.add(salameche);

        ArrayList<Attaque> carapuce_a = new ArrayList<Attaque>() {{add(ecume);add(cascade);}};
        Polymon carapuce = new Polymon("Polymon_3","Carapuce","Carapuce est une petite tortue bipède de couleur bleue. Il possède une carapace majoritairement brune, jaune pâle au niveau du ventre. Ses yeux sont grands et violacés. Il a une queue avec un motif de spirale à son extrémité. Il possède quatre pattes avec chacune trois doigts.", 50,carapuce_a);
        polymons.add(carapuce);

        ArrayList<Attaque> pikachu_a = new ArrayList<Attaque>() {{add(cageEclair);add(eclair);}};
        Polymon pikachu = new Polymon("Polymon_4","Pikachu","Pikachu est un petit Polymon joufflu qui ressemble à un rongeur, au corps recouvert d’un pelage jaune avec deux bandes horizontales brunes dans le dos. Il a une petite bouche, de longues oreilles pointues aux extrémités noires et des yeux marron. Il a sur chacune de ses joues un marquage rouge qui est en réalité une poche contenant de l’électricité.", 60,pikachu_a);
        polymons.add(pikachu);

        ArrayList<Attaque> goupix_a = new ArrayList<Attaque>() {{add(lanceFlammes);add(deflagration);}};
        Polymon goupix = new Polymon("Polymon_5","Goupix","Goupix est un petit Polymon quadrupède à l’allure vulpine. Son pelage est rouge tomette avec un ventre de couleur crème. Il a de grands yeux noisette, des oreilles pointues à l’intérieur brun et un petit museau brun. Le pelage de ses pattes est légèrement plus foncé que sur le reste de son corps et il a de petits coussinets brun clair.", 60,goupix_a);
        polymons.add(goupix);

        ArrayList<Attaque> nosferapti_a = new ArrayList<Attaque>() {{add(coupDeBoule);add(acide);}};
        Polymon nosferapti = new Polymon("Polymon_6","Nosferapti","Nosferapti est une petite chauve-souris bleu foncé. La membrane de ses ailes est violette, tout comme le creux de ses grandes oreilles. Sa mâchoire possède quatre crocs apparents. Ses membres inférieurs ne sont pas munis de pieds et son visage ne possède pas d'yeux, puisque ce Pokémon utilise des ultrasons pour se déplacer dans l'obscurité des grottes où il vit principalement.", 30,nosferapti_a);
        polymons.add(nosferapti);

        ArrayList<Attaque> miaouss_a = new ArrayList<Attaque>() {{add(fouet);add(coupDeBoule);}};
        Polymon miaouss = new Polymon("Polymon_7","Miaouss","Miaouss ressemble à un chat, à la différence qu'il se tient la plupart du temps sur ses deux pattes arrière. Il a le corps beige, le bout des pattes et de la queue marron et les oreilles noires. Sa pièce dorée fixée sur son front a une relative ressemblance avec la Pièce Rune.", 60,miaouss_a);
        polymons.add(miaouss);

        ArrayList<Attaque> psykokwak_a = new ArrayList<Attaque>() {{add(belier);add(ecume);}};
        Polymon psykokwak = new Polymon("Polymon_8","Psykokwak","Psykokwak a l'allure générale d'un ornithorynque jaune. Il a un bec jaune pâle un peu aplati, les pattes de la même couleur que son bec. Il est souvent pris de migraines, qui lui permettent d'utiliser de puissants pouvoirs psychiques. Malgré ces pouvoirs mentionnés par le Polydex, il n'est pas de type Psy.",60,psykokwak_a);
        polymons.add(psykokwak);

        ArrayList<Attaque> noeunoeuf_a = new ArrayList<Attaque>() {{add(acide);add(coupDeBoule);}};
        Polymon noeunoeuf = new Polymon("Polymon_9","Noeunoeuf","Noeunoeuf est habituellement composé de six entités ressemblant à des œufs avec un visage souvent menaçant. La plupart de ces œufs sont craquelés par endroits, l'un d'eux est ouvert et laisse apparaître son jaune.",60,noeunoeuf_a);
        polymons.add(noeunoeuf);

        ArrayList<Attaque> insecateur_a = new ArrayList<Attaque>() {{add(fouet);add(pique);}};
        Polymon insecateur = new Polymon("Polymon_10","Insecateur","Insécateur est inspiré de la mante religieuse verte. Bipède, il se tient sur deux larges pattes équipées de trois griffes. Il possède deux paires d'ailes, et deux grandes faux en guise de bras.",80,insecateur_a);
        polymons.add(insecateur);

        ArrayList<Attaque> scarabrute_a = new ArrayList<Attaque>() {{add(pique);add(sangsue);}};
        Polymon scarabrute = new Polymon("Polymon_11","Scarabrute","Scarabrute ressemble à un scarabée marron bipède qui, au lieu d'avoir des mandibules, possède deux cornes avec plusieurs petits pics sur sa tête. Il a un regard agressif et possède une bouche à dix dents (cinq en vertical de chaque côté). Il a de petits bras et trois doigts griffus et possède de grands pieds avec trois orteils (deux devant et un derrière).",80,scarabrute_a);
        polymons.add(scarabrute);

        ArrayList<Attaque> magmar_a = new ArrayList<Attaque>() {{add(seisme);add(deflagration);}};
        Polymon magmar = new Polymon("Polymon_12","Magmar","Magmar a le corps parsemé de motifs de flammes orange et jaune. Ses mains sont dotées de griffes acérées à leurs extrémités, tout comme ses pieds. Deux flammes ardentes crépitent sur sa tête et sa queue se termine par une flamme. Son cou et ses jambes sont noirs.",80,magmar_a);
        polymons.add(magmar);

        ArrayList<Attaque> leviator_a = new ArrayList<Attaque>() {{add(hydrocanon);add(seisme);}};
        Polymon leviator = new Polymon("Polymon_13","Leviator","Léviator est un Polymon à l'allure serpentine avec un long corps principalement bleu à l'exception de son ventre et de quelques une de ses écailles qui sont jaune pâle. Sa bouche aux lèvres jaunes est très large et révèle, une fois grande ouverte, quatre dents pointues. Il a un barbillon et une petite nageoire blanche sur chaque côté de la tête. Il a de petits yeux rouges, une crête bleu foncé sur la tête et quatre nageoires dorsales blanches.",90,leviator_a);
        polymons.add(leviator);

        ArrayList<Attaque> ptera_a = new ArrayList<Attaque>() {{add(frappeAtlas);add(fouet);}};
        Polymon ptera = new Polymon("Polymon_14","Ptera","Ptéra ressemble à un grand reptile carnassier gris-violet volant grâce à des membranes tendues entre ses doigts, proche du ptérodactyle dont il tire son nom. Ptéra est constitué de roche (dont le poids ne semble étonnement pas l'empêcher de voler), d'où sa classification en Polymon de base de type Roche et Vol.",80,ptera_a);
        polymons.add(ptera);

        ArrayList<Attaque> dracolosse_a = new ArrayList<Attaque>() {{add(seisme);add(frappeAtlas);}};
        Polymon dracolosse = new Polymon("Polymon_15","Dracolosse","Dracolosse est un Polymon bipède ressemblant à un dragon à la peau jaune foncé. Il est grand, assez costaud, a des yeux de couleur vert kaki, et il possède deux petites ailes bleu vert dans le dos lui permettant de voler. Il possède une corne et deux antennes blanches sur sa tête, trois griffes sur ses mains et ses pieds et une queue.",120,dracolosse_a);
        polymons.add(dracolosse);

        ArrayList<Attaque> rhinoferos_a = new ArrayList<Attaque>() {{add(frappeAtlas);add(seisme);}};
        Polymon rhinoferos = new Polymon("Polymon_16","Rhinoferos","Rhinoféros ressemble à un rhinocéros redressé sur ses pattes arrière. Il possède une unique corne sur le museau, qui a un motif en spirale, tel celui d'une foreuse. Il a une longue queue avec les mêmes motifs que sur sa corne.",110,rhinoferos_a);
        polymons.add(rhinoferos);

        ArrayList<Attaque> aquali_a = new ArrayList<Attaque>() {{add(ecume);add(hydrocanon);}};
        Polymon aquali = new Polymon("Polymon_17","Aquali","Aquali est un Polymon qui partage des traits physiques avec des animaux marins et terrestres. Il est quadrupède avec trois petits orteils à chaque pied et un coussinet bleu foncé sur ses pattes postérieures. Le corps d'Aquali est bleu clair avec une marque bleu foncé sur la tête et une arête sur son dos.",100,aquali_a);
        polymons.add(aquali);

        ArrayList<Attaque> sulfura_a = new ArrayList<Attaque>() {{add(comete);add(lanceFlammes);}};
        Polymon sulfura = new Polymon("Polymon_18","Sulfura","Sulfura est un grand oiseau de couleur jaune orangé. Il possède un long bec marron, et est reconnaissable à ses ailes, crête et panache enflammés rouge et rose. Il a également une queue enflammée rouge et rose. Il a des serres marron à quatre orteils (un derrière et trois devant). Il a des yeux triangulaires noirs.",130,sulfura_a);
        polymons.add(sulfura);

        ArrayList<Attaque> mew_a = new ArrayList<Attaque>() {{add(comete);add(ombreNocturne);}};
        Polymon mew = new Polymon("Polymon_19","Mew","Peu de choses sont connues à son propos. Il est dit qu'autrefois, les Mew étaient nombreux, mais tous auraient disparu sauf un. Ce Polymon mythique peut apprendre la plupart des capacités, c'est pour cela que certains pensent qu'il est l'ancêtre de tous les Polymon. Par ailleurs, Mew est connu pour avoir été cloné afin de créer Mewtwo.",140,mew_a);
        polymons.add(mew);

        ArrayList<Attaque> mewtwo_a = new ArrayList<Attaque>() {{add(ombreNocturne);add(comete);}};
        Polymon mewtwo = new Polymon("Polymon_20","Mewtwo","Comme Mewtwo a été créé à partir de Mew, il est également à mi-chemin entre le chat (pour la tête) et la gerboise (pour le reste du corps), à la différence qu'il mesure 2 mètres et a des membres plus longs que ceux de Mew, lui donnant une apparence presque humanoïde. Il se déplace la plupart du temps en lévitant. Mewtwo est un Polymon principalement mauve (ou blanc selon les versions). Il possède une longue queue violette qui remonte jusqu'au bas de son ventre.",150,mewtwo_a);
        polymons.add(mewtwo);

        ArrayList<Polymon> step_1_p = new ArrayList<Polymon>() {{add(mew);add(mewtwo);}};
        Step step_1 = new Step("Step_1", "Espace", "La voie lactee","espace", step_1_p, null );
        steps.add(step_1);

        ArrayList<Polymon> step_2_p = new ArrayList<Polymon>() {{add(rhinoferos);add(sulfura);}};
        ArrayList<String> step_2_s = new ArrayList<String>() {{add(step_1.getId());}};
        Step step_2 = new Step("Step_2", "Volcan", "Le volcan","feu", step_2_p, step_2_s );
        steps.add(step_2);

        ArrayList<Polymon> step_3_p = new ArrayList<Polymon>() {{add(magmar);add(sulfura);}};
        Step step_3 = new Step("Step_3", "Aurore boreale", "L'aurore boreale","boreal", step_3_p, step_2_s );
        steps.add(step_3);

        ArrayList<Polymon> step_4_p = new ArrayList<Polymon>() {{add(aquali);add(leviator);}};
        ArrayList<String> step_4_s = new ArrayList<String>() {{add(step_2.getId());add(step_3.getId());}};
        Step step_4 = new Step("Step_4", "Ocean", "L'ocean","eau", step_4_p, step_4_s );
        steps.add(step_4);

        ArrayList<Polymon> step_5_p = new ArrayList<Polymon>() {{add(aquali);add(psykokwak);}};
        Step step_5 = new Step("Step_5", "Marecage", "Le marecage","marais", step_5_p, step_4_s );
        steps.add(step_5);

        ArrayList<Polymon> step_6_p = new ArrayList<Polymon>() {{add(insecateur);add(scarabrute);}};
        ArrayList<String> step_6_s = new ArrayList<String>() {{add(step_4.getId());add(step_5.getId());}};
        Step step_6 = new Step("Step_6", "Foret", "La foret","foret", step_6_p, step_6_s );
        steps.add(step_6);

        ArrayList<Polymon> step_7_p = new ArrayList<Polymon>() {{add(dracolosse);add(ptera);}};
        Step step_7 = new Step("Step_7", "Grotte", "La grotte","grotte", step_7_p, step_6_s );
        steps.add(step_7);

        ArrayList<Polymon> step_8_p = new ArrayList<Polymon>() {{add(psykokwak);add(noeunoeuf);}};
        ArrayList<String> step_8_s = new ArrayList<String>() {{add(step_6.getId());add(step_7.getId());}};
        Step step_8 = new Step("Step_8", "Marais", "Le marais","marais", step_8_p, step_8_s );
        steps.add(step_8);

        ArrayList<Polymon> step_9_p = new ArrayList<Polymon>() {{add(miaouss);add(goupix);}};
        Step step_9 = new Step("Step_9", "Hautes herbes", "Les hautes herbes","herbes", step_9_p, step_8_s );
        steps.add(step_9);

        ArrayList<Polymon> step_10_p = new ArrayList<Polymon>() {{add(nosferapti);add(pikachu);}};
        ArrayList<String> step_10_s = new ArrayList<String>() {{add(step_8.getId());add(step_9.getId());}};
        Step step_10 = new Step("Step_10", "Caverne", "La caverne","grotte", step_10_p, step_10_s );
        steps.add(step_10);

        ArrayList<Polymon> step_11_p = new ArrayList<Polymon>() {{add(miaouss);add(goupix);}};
        Step step_11 = new Step("Step_11", "Grande prairie", "La grande prairie","herbes", step_11_p, step_10_s );
        steps.add(step_11);

        ArrayList<Polymon> step_12_p = new ArrayList<Polymon>() {{add(nosferapti);}};
        ArrayList<String> step_12_s = new ArrayList<String>() {{add(step_10.getId());add(step_11.getId());}};
        Step step_12 = new Step("Step_12", "Paturage", "Les paturages","herbes", step_12_p, step_12_s );
        steps.add(step_12);

        Parcours p = new Parcours("Parcours_1", "Kanto", "La région de Kanto possède des paysages variés, tels que des grottes et des forêts. Cette diversité permet à de nombreux Polymon de vivre dans ces différents habitats.", step_12);
        parcours.add(p);

        return repository.initializeDatabase(polymons, attaques, steps, parcours);
    }

    /**
     * Méthode permettant d'afficher dans la sortie standard l'ensemble des <i>Polymons</i> présents en base de données
     */
    public void afficheAllMonstre() {
        List<Polymon> polymons = repository.getAllMonstre();

        for(Polymon polymon : polymons) {
            System.out.println("Le polymon d'id " + polymon.getId() + " s'appelle " + polymon.getNom());
        }
    }
}

package alphaws.com.javadevday.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import alphaws.com.javadevday.beans.Place;

/**
 * Created by Daniel on 21/07/2015.
 */
public class DataBaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "JavaDevDay.db";
    private static final int DATABASE_VERSION = 1;

    //TABLES
    public static final String PLACE = "Place";
    public static final String EVENT = "Event";
    public static final String MEMBER = "Member";

    //COLUMNS
    public static final String PLACE_IDPLACE = "IdPlace";
    public static final String PLACE_NAME = "Name";

    public static final String EVENT_IDEVENT = "idEvent";
    public static final String EVENT_IDPLACE = "IdPlace";
    public static final String EVENT_IDMEMBER = "IdMember";
    public static final String EVENT_DETAIL = "Detail";
    public static final String START_HOUR = "Start_Hour";
    public static final String FINAL_HOUR = "Final_Hour";
    public static final String FAVOURITE = "Favourite";
    public static final String EVENT_DESC = "Descpription";
    public static final String EVENT_SPEAKERS = "Speakers";

    public static final String MEMBER_IDMEMBER = "IdMember";
    public static final String MEMBER_NAME = "Name";
    public static final String MEMBER_DETAIL = "Detail";

    private static DataBaseHandler databaseHandler;

    public static DataBaseHandler getInstance(Context context){
        if(databaseHandler == null){
            databaseHandler = new DataBaseHandler(context);
        }
        return databaseHandler;
    }

    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //LUGARES
        ////////////
        //////////
        ////////////////
        String sql = "CREATE TABLE " + PLACE
                + " (" + PLACE_IDPLACE + " INTEGER PRIMARY KEY, "
                +  PLACE_NAME + " TEXT);";
        db.execSQL(sql);

        sql = "INSERT INTO " + PLACE + " VALUES (" + 2 + ", 'Android/JS - W107');";
        db.execSQL(sql);

        sql = "INSERT INTO " + PLACE + " VALUES (" + 3 + ", 'Lenguajes JVM  - W108');";
        db.execSQL(sql);

        sql = "INSERT INTO " + PLACE + " VALUES (" + 4 + ", 'Java EE - W109');";
        db.execSQL(sql);

        sql = "INSERT INTO " + PLACE + " VALUES (" + 5 + ", 'Arquitectura/Metodología - W110');";
        db.execSQL(sql);

        sql = "INSERT INTO " + PLACE + " VALUES (" + 6 + ", 'Java SE - W111');";
        db.execSQL(sql);

        sql = "INSERT INTO " + PLACE + " VALUES (" + 7 + ", 'Hardware/IoT/BigData - W105/106');";
        db.execSQL(sql);

        sql = "INSERT INTO " + PLACE + " VALUES (" + 1 + ", 'Auditorio Arrupe');";
        db.execSQL(sql);

        //EVENTOS

        sql = "CREATE TABLE " + EVENT + " (" + EVENT_IDEVENT + " INTEGER PRIMARY KEY, " + EVENT_IDPLACE + " INTEGER, "
        + EVENT_IDMEMBER + " INTEGER, " + EVENT_DETAIL + " TEXT, " + START_HOUR + " TEXT, "
        + FINAL_HOUR + " TEXT, " + FAVOURITE + " INTEGER, " + EVENT_DESC + " TEXT, " + EVENT_SPEAKERS + " TEXT);";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 1 + ", " + 1 + ", " + 0 + ", 'Recepción', " +
                "'09:00', '09:30', " + 0 + ", '', '');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 2 + ", " + 1 + ", " + 0 + ", 'Inauguración', " +
                "'09:30', '10:00', " + 0 + ", '', '');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 3 + ", " + 2 + ", " + 19 + ", 'The Smartwatch Revolution begins: Developing for Android Wear', " +
                "'10:00', '10:45', " + 0 + ", 'Wearable computing is growing in popularity with the introduction of consumer devices by Google with Android Wear. In this session," +
                " we´ll talk about the challenges of developing for Smartwatches. Well work through a complete example of coding a Android Wear app and discuss the architecture of " +
                "Smartwatch enabled apps.\n" + "\n" + "Wearable computing is growing in popularity with the " +
                "introduction of consumer devices by Google with Android Wear. " +
                "In this session, well talk about the challenges of developing for Smartwatches. Well work through a complete example of coding a Android Wear " +
                "app and discuss the architecture of Smartwatch enabled apps.', 'Pratik Patel');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 4 + ", " + 2 + ", " + 18 + ", 'Geolocalización. Un nuevo reto para todos', " +
                "'11:00', '11:45', " + 0 + ", 'Las aplicaciones de hoy en dia requieren de adecuarse las necesidades del marketing digital. Su implementación es todo un reto', 'Jorge Vargas');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 5 + ", " + 2 + ", " + 10 + ", 'El nuevo look de Android: Material Design', " +
                "'12:00', '12:45', " + 0 + ", 'Hablaremos sobre el encanto de Material Design y como las nuevas librerías nos ayudan a implementarlo de manera rápida y sencilla', 'Pedro Hernández');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 6 + ", " + 1 + ", " + 0 + ", 'Comida', " +
                "'13:00', '14:00', " + 0 + ", '', '');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 7 + ", " + 2 + ", " + 19 + ", 'High Performance JavaScript Web Apps', " +
                "'14:00', '14:45', " + 0 + ", 'In this session, well dig deep into the performance aspects of JavaScript and the Web Browser. Single page web " +
                "applications are becoming popular very quickly, and understanding the low-level and high-level aspects of the browser platform and JavaScript runtimes " +
                "embedding in them are important. We´ll cover topics such as browser pipe-lining, memory management, testing and measuring performance.', 'Pratik Patel');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 8 + ", " + 2 + ", " + 10 + ", 'Android Wearables, Smart Watch', " +
                "'15:00', '15:45', " + 0 + ", 'While the clue´s in the name, it doesn´t tell the whole story. Wearable technology is clearly gadgets you wear, but there are distinctions. Wearable " +
                "technology is not a trendy pair of headphones  or only a digital watch.\n" +
                "This age of wearables tap into the connected self, laden with smart sensors, make use of web connection, usually using Bluetooth to connect wirelessly to our smartphones. \n" +
                "We will learn a little bit more about the Android Wearable Platform and how to implement it in a Motorola 360 smart watch.', 'Oscar Vargas, Patrick Bertsch');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 9 + ", " + 2 + ", " + 18 + ", 'Android trends', " +
                "'16:00', '16:45', " + 0 + ", 'Hablaremos sobre las tendencias de desarrollo de aplicaciones en android que han causado más ruido en el último año. Tales cómo retrofit, " +
                "rxjava , MVP, MVVM , dependency injection y otras más.', 'Pedro Hernández');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 10 + ", " + 1 + ", " + 19 + ", '7 Tips for a Successful Hackathon (or Startup Weekend', " +
                "'17:00', '17:45', " + 0 + ", 'You´re tired of your boring job and ready to enter a hackathon to do something special with you elite coding skills. " +
                "Perhaps you even have a great idea, or you´re ready to join a startup. Hackathons are a great way to jump-start your journey into the world of startups. " +
                "Come to this session and learn 7 tips for making your hackathon experience fun and successful. The presenter has participated in (and won) several hackathons " +
                "and his current company launched from a Startup Weekend.', 'Pratik Patel');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 11 + ", " + 1 + ", " + 0 + ", 'Cierre', " +
                "'18:00', '18:30', " + 0 + ", '', '');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 12 + ", " + 3 + ", " + 12 + ", 'Clojure for Java Developers', " +
                "'14:00', '14:45', " + 0 + ", 'Clojure puede parecer un lenguaje inútil, pero podemos aprender a verlo como un lenguaje divertido, retando " +
                "nuestra manera de pensar y obligandonos a hacerlo de una manera diferente.\n" +
                "Además de todo esto funciona sobre la JVM, y podemos usarlo para cosas de la vida real!\n" +
                "La idea de esta plática es que entiendas lo que Clojure puede hacer por ti, y enamorate!', 'Eduardo Díaz');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 13 + ", " + 3 + ", " + 3 + ", 'JRuby, la JVM y Torquebox', " +
                "'11:00', '11:45', " + 0 + ", 'Ruby, junto con Rails, son una excelente plataforma para desarrollar aplicaciones web.\n" +
                "El problema para ponerlo en producción es que el equipo de infraestructura normalmente ya tiene la JVM y no es conveniente agregar mas elementos para " +
                "administrar. Por otra parte, se sabe muy bien que el runtime de Ruby no es el mas eficiente que existe, sobre todo comparado con la JVM.\n" +
                "En está platica explicare como utilizar JRuby y  Torquebox para desplegar aplicaciones en producción y los beneficios que esto trae tanto para " +
                "el equipo de desarrollo como para el equipo de infraestructura. Veremos las ganancias que se obtienen de performance y de facilidad de despliegue. " +
                "Especialmente aprovechando la nueva opción de desplegar aplicaciones sin usar un Application Server.', 'Norberto Ortigoza');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 14 + ", " + 3 + ", " + 11 + ", 'Ceylon, una alternativa sencilla a Java', " +
                "'12:00', '12:45', " + 0 + ", 'Ceylon es un nuevo lenguaje de programación con tipado estático, su propio SDK, sistema modular, que corre sobre la " +
                "JVM y también sobre plataformas JavaScript. El objetivo de esta charla es dar una intro rápida al lenguaje y mostrar por qué puede ser una buena alternativa " +
                "a Java, ya que permite seguir aprovechando las ventajas del tipado estático, con una sintaxis sencilla y construcciones del lenguaje que permiten una mayor " +
                "expresividad que Java.', 'Enrique Zamudio');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 15 + ", " + 3 + ", " + 7 + ", 'Práctica deliberada ', " +
                "'10:00', '10:45', " + 0 + ", 'En la industria del software es común que los desarrolladores se entrenen en la teoría para después trabajar directamente en proyectos.\n" +
                "Pero como en otras profesiones (música, deportes, medicina o artes marciales), podemos usar la practica deliberada para ejercitar nuestra memoria, el pensamiento " +
                "lógico y aprender nuevas ideas desde diferentes perspectivas.\n" +
                "En esta conferencia se hablara sobre la importancia de la práctica en nuestra profesión y porque solo la teoría no es suficiente, " +
                "se hará en vivo una kata sincronizada con música.', 'Javier Cervantes');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 16 + ", " + 3 + ", " + 10 + ", 'Tour de Ceylon', " +
                "'15:00', '15:45', " + 0 + ", 'Este taller tiene como objetivo mostrar las características principales del lenguaje y de la plataforma de Ceylon, " +
                "con una serie de programas sencillos que los participantes puedan modificar" +
                " en el momento para conocer esta nueva tecnología de manera más directa.', 'Enrique Zamudio');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 17 + ", " + 3 + ", " + 21 + ", 'Haskell for Java Programmers', " +
                "'17:00', '17:45', " + 0 + ", 'Java is statically typed, but often there are debates about how the typing gets in our ways. Haskell has largely been " +
                "credited for its static typing and for enforcing the functional programming paradigm. Learning about Haskell can help us program in Java better " +
                "and even borrow some nice pattern of programming.\n" +
                "In this presentation we will learn about some of the fundamentals of Haskell and also take a look at using Haskell on the JVM.', 'Venkat Subramaniam');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 18 + ", " + 3 + ", " + 0 + ", 'Realtime Apps with VertX', " +
                "'16:00', '16:45', " + 0 + ", '¿Qué es Vert.X?\n" +
                "Es una de las pocas plataformas de desarrollo verdaderamente políglota, proporciona interoperabilidad sin fisuras entre " +
                "los componentes escritos en JavaScript, CoffeeScript, Java, Ruby, Python y Groovy. Proporciona un framework de gran alcance que escala a una multitud de escenarios de usos diferentes. \n" +
                "Temas que se impartirán:\n" +
                "Arquitectura de aplicaciones orientadas a eventos\n" +
                "Que es vertx?\n" +
                "Programación poliglota\n" +
                "Módulos de vertx\n" +
                "Demostración', 'José Juan Reyes');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 19 + ", " + 4 + ", " + 20 + ", 'JavaEE.Next():Java EE 7, 8, and Beyond', " +
                "'10:00', '10:45', " + 0 + ", 'Java EE 7 is here and the horizons for Java EE 8 are emerging. This session looks into the key changes the community can expect. The goal of this session is to " +
                "foster interest and discussion around these changes. \n" +
                "Some of the changes discussed include retiring EJB 2 entity beans and JAX-RPC, greater alignment with CDI, WebSocket/HTML 5 support, " +
                "a standard API for JSON processing, the next version of JAX-RS, an overhaul of JMS, long-awaited concurrency utilities, batch processing in Java EE and much, " +
                "much more.', 'Reza Rahman');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 20 + ", " + 1 + ", " + 15 + ", 'Developing and Running Java EE Apps Entirely in the Cloud', " +
                "'11:00', '11:45', " + 0 + ", 'Today’s developers want platforms that make innovation faster, less complex, and more efficient. IT administrators " +
                "want platforms that are flexible and easy to maintain, whereas executives want higher productivity and agility along with pay-for-use. Attend this " +
                "session to learn why developers, administrators, and executives come to love Oracle’s Java platform in the public cloud. See a demo on how you can transform " +
                "the development experience and quickly build and deploy applications, be they existing Java applications, new ones, or simply extensions to Oracle software" +
                " as a service (SaaS) services, in the cloud, using tools and techniques developers love and already use today', 'Bruno Borges');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 21 + ", " + 1 + ", " + 20 + ", 'Why Open Standards and Java/EE Matter', " +
                "'12:00', '12:45', " + 0 + ", 'Words like standard, de-facto, de-jure and open are commonly traded around like cheap coins in our " +
                "industry, ironically sometimes as a tool for overt or covert standards bashing. The reality is that few people really understand " +
                "what these words actually mean or how these ideas effect their own professional lives in the long and short term. \n" +
                "This session will aim to clear the air on some of these terms and outline why open standards like Java and Java EE are critically " +
                "important to you today and in the future. We will explore these concepts in the context of well-established economic theories on competition, " +
                "monopoly power, the network effect, innovation, open source and open standards. We will also discuss what being an open standard really means " +
                "as well as why and how you should contribute to them yourself.', 'Reza Rahman');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 22 + ", " + 1 + ", " + 16 + ", 'Participate in the Future of Java', " +
                "'15:00', '15:45', " + 0 + ", 'Learn how to take part in Java technology evolution through the Java Community Process (JCP) program. " +
                "You can participate as an individual, corporation, or nonprofit such as a Java user group (JUG). This session gives you step-by-step instructions " +
                "on how to participate in the JCP Program. You will also learn about the global Adopt-a-JSR program and how you can participate in the Adopt-a-JSR program. " +
                "We will discuss details such as how to run hack days, collaborate with other JUG leads on Adopt-a-JSR activities, and review use cases from other JUGs " +
                "around the world contributing to the Java EE 7 and Java SE 8 JSRs. Currently there are new JSRs being submitted and developed for the Java EE 8 and Java " +
                "SE 9 platforms. Find out how you have contribute to the future editions of the Java Standard and Java Enterprise Editions.', 'Heather VanCura');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 23 + ", " + 1 + ", " + 20 + ", 'Down-to-Earth Microservices with Java EE', " +
                "'16:00', '16:45', " + 0 + ", 'Microservices seems to have become the new kid of the buzzword block in our ever colorful industry. In this session we " +
                "will explore what microservices really mean within the relatively well established context of distributed computing/SOA, when they make sense and " +
                "how to develop them using the lightweight, simple, productive Java EE programming model. \n" +
                "We´ll explore microservices using a simple but representative example using Java EE. You´ll see how the Java EE programming model and APIs like JAX-RS," +
                " WebSocket, JSON-P, Bean Validation, CDI, JPA, EJB 3, JMS 2 and JTA aligns with the concept of microservices. \n" +
                "It may or may not surprise you to learn in the end that you already know more about microservices than you realize and that it is an architectural " +
                "style that does not really require you to learn an entirely new tool set beyond the ones you already have. You might even see that Java EE is a " +
                "particularly powerful and elegant tool set for developing microservices.', 'Reza Rahman');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 24 + ", " + 4 + ", " + 20 + ", 'Java EE 8 - Community Update and Panel', " +
                "'17:00', '17:45', " + 0 + ", 'Join a group of experts in this session to discuss ideas and wishes for Java EE 8. To solidly kick-start Java EE 8, " +
                "the Oracle Java EE team conducted a community survey. The session shares some of this content, plus results and analysis of the survey. The goal " +
                "is to foster interest in and discussion of the items covered by the survey: JSON binding; JCache; CDI/EJB alignment; the cloud; PaaS; multitenancy; " +
                "SaaS; JMS; JAX-RS; security; testability; configuration; NoSQL; an action-based web framework; HTML 5/JavaScript alignment; mobility; and much, " +
                "much more. You are encouraged to bring your questions, comments, and ideas. The time to get involved in shaping the future of Java EE is now!', 'Reza Rahman, Bruno Borges y Heather VanCura');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 25 + ", " + 4 + ", " + 20 + ", 'Using JavaScript/HTML5 Rich Clients with Java EE 7', " +
                "'14:00', '14:45', " + 0 + ", 'The sea change in HTML5 is poised to shift the pendulum away from today´s thin-client based server-side web frameworks like " +
                "Struts 2 and JSF to JavaScript powered rich clients. With strong support for REST, WebSocket and JSON, Java EE is well positioned to adapt to this landscape. \n" +
                "In this heavily code driven session, we will show you how you can utilize today´s most popular JavaScript rich client technologies like AngularJS, Backbone, " +
                "Knockout and Ember to utilize the core strengths of Java EE using JAX-RS, JSR 356/WebSocket, JSON-P, CDI and Bean Validation.', 'Reza Rahman');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 26 + ", " + 5 + ", " + 4 + ", 'Diseñando una arquitectura de alto desempeño con pocos recursos... humanos y técnicos', " +
                "'10:00', '10:45', " + 0 + ", 'Cuando se requiere hacer un diseño de una aplicación, se debe arquitectura pensando en cumplir el objetivo, pero sobre todo considerando con que recursos contamos " +
                "para implementarlo y soportarlo.', 'Jorge Vargas');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 27 + ", " + 5 + ", " + 19 + ", 'React.js Super-fast Single Page Web App', " +
                "'11:00', '11:45', " + 0 + ", 'React.js is a view library from Facecbook for building performant user-interfaces in JavaScript. In this session, we´ll explore React.js and understand why it´s a great " +
                "step forward for building complex UI´s that run fast. We´ll code up an example web application using React.js and step through the basics of using the library " +
                "while discussing concepts like the virtual DOM and components.\n" +
                "In this session, we´ll explore React.js and understand why it´s a great step forward for building complex UI´s that run fast. We´ll " +
                "code up an example web application using React.js and step through the basics of using the library while discussing concepts like the shadow DOM and components.', " +
                "'Pratik Patel');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 28 + ", " + 5 + ", " + 0 + ", 'Websocket o de la importancia de ser full duplex', " +
                "'12:00', '12:45', " + 0 + ", 'Con la llegada de WebSocket, la construcción de aplicaciones (principalmente web) deberá cambiar un poco su paradigma de diseño.\n" +
                "Las implicaciones también son del lado del back-end, debemos conocer que plataformas traen ya \"out-of-the-box\" sus propias implementaciones.\n" +
                "Los navegadores deberán llevar a la par su soporte de websocket con lo que vaya dictando la especificación.\n" +
                "Como vemos, no es sólo una nueva tecnología, es también un nuevo paradigma. Y es importante conocerlo desde las bases.\n" +
                "En esta charla conoceremos las bases de esta tecnología y las implicaciones que tiene en el ecosistema java.', 'Issac Ruiz Guerra');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 29 + ", " + 5 + ", " + 9 + ", 'Como construir APIs REST para sistemas distribuidos con alta escalabilidad y resilencia', " +
                "'15:00', '15:45', " + 0 + ", 'En esta charla se abordaran los diversos retos que se presentan cuando se requieren diseñar APIs REST usando la JVM. Los retos que se deben " +
                "afrontar son diversos y cada uno de ellos tiene su contexto y complejidad.\n" +
                "- Contrato del API. ¿Como no romper el API? ¿Como proveer soporte para diversas versiones? ¿Como documentar?\n" +
                "- Modelo de programación del API. ¿Que tipo de REST hacer? ¿que framework elegir? ¿que lineamientos de desarrollo seguir? " +
                "Debemos crear un cliente del API? ¿Debemos generar clientes del API para dispositivos móviles?\n" +
                "- ¿Debe ser mi API distribuida? ¿Necesito interactuar con sistemas externos? ¿Como debe mi API soportar caídas de sistemas externos? " +
                "¿Que es eso de resilencia? ¿Debo ser mi API residente por diseño?\n" +
                "- ¿Debo soportar altas cargas de trafico en cortos periodos de tiempo? ¿Como diseño mi API para que sea escalable? ¿Como implemento alta " +
                "disponibilidad? ¿Debo correr en la nube para escalar automáticamente? ¿Como hago escalamiento de mi API si no corro en la nube?\n" +
                "- ¿Como despliego mi API? ¿Debo resolver el aprovisionamiento de recursos que mi API necesita? ¿Que es eso de Linux Containers? ¿Me sirve Docker " +
                "para correr mi API? ¿Como ejecuto mi API en mi ambiente local?\n" +
                "En la charla hablaré de todos estos cuestionamientos y de una propuesta de solución usando la JVM, algunas especificaciones, bibliotecas, frameworks y prácticas.', 'Domingo Suárez');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 30 + ", " + 5 + ", " + 13 + ", 'Sistemas tolerantes a falla', " +
                "'17:00', '17:45', " + 0 + ", '¿Cuánto cuesta a una organización cuando un sistema falla? ¿Cuál es el impacto de que todo un sistema esté fuera de operación " +
                "por una falla inesperada? ¿Hay manera de crear sistemas que continúen funcionando aún cuando, por ejemplo, un proceso o sub-sistema muere o no está disponible? " +
                "¿Crees que todo esto se puede arreglar con un bloque “try-catch” bien colocado? \n" +
                "En esta sesión platicaré sobre la importancia de crear sistemas robustos y tolerantes a fallas, explicando las propiedades básicas que un sistema debe cumplir " +
                "para continuar funcionando aún en la presencia de errores inesperados. Presentaré también varios patrones de diseño con el código correspondiente para que comiences " +
                "a introducir robustez y tolerancia a fallas a los sistemas con que trabajas.', 'Agustin Ramos');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 31 + ", " + 5 + ", " + 19 + ", 'The Modern JavaScript Server Stack', " +
                "'16:00', '16:45', " + 0 + ", 'The usage of JavaScript on the server is rising. In this session, we´ll talk about all the tools and utilities that comprise a modern JavaScript application, " +
                "from a server-side point of view.\n" +
                "The usage of JavaScript on the command line and server has exploded over the past couple of " +
                "years. Node.js has become popular with development shops from startups to big corporations. " +
                "With its asynchronous nature, JavaScript provides the ability to scale dramatically. Along with the ability to drive your server-side applications, " +
                "there are a number of tools that help with all aspects of browser development: testing, packaging, and deployment. In this session, we´ll explore " +
                "these tools and show you how you can incorporate these into your environment.', 'Pratik Patel');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 32 + ", " + 5 + ", " + 5 + ", 'Desarrollo de aplicaciones con Netbeans Platform', " +
                "'14:00', '14:45', " + 0 + ", 'En muchos casos es necesario desarrollar una aplicación Standalone en Java para proporcionar funcionalidad que " +
                "no se puede obtener en un entorno Web, NetBeans Platform proporciona un Framework en el que pueden desarrollar aplicaciones de escritorio de gran tamaño. " +
                "La plataforma NetBeans contiene APIs que simplifican el manejo de ventanas, acciones, archivos y muchas otras cosas típicas en las aplicaciones swing. " +
                "Netbeans Platform permite el desarrollo modular de aplicaciones (plugins) que pueden instalarse directamente en el IDE.\n" +
                "El objetivo del taller es guiar a los participantes para que desarrollen una aplicación que haga uso de los principales componentes del Framework " +
                "de Netbeans Platform.', 'Tito Marcos');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 33 + ", " + 1 + ", " + 21 + ", 'The Joy of Functional Programming', " +
                "'10:00', '10:45', " + 0 + ", 'It´s been around for a long time, but everyone´s talking about it all of a sudden. But why and why now? We´ve been programming in " +
                "languages like Java for a while, quite well. Now we´re asked to change and the languages themselves are changing towards this style of programming.\n" +
                "In this keynote, a passionate polyglot programmer and author of \n" +
                "“Functional Programming in Java: Harnessing the Power of Java 8 Lambda Expressions” will share the reasons we need to make the paradigm shift and the pure " +
                "joy—the benefits—we will reap from it.', 'Venkat Subramaniam');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 34 + ", " + 6 + ", " + 21 + ", 'Java 8 Lambdas, the Path way to Functional Style', " +
                "'11:00', '12:45', " + 0 + ", 'Functional programming has gained the recognition it deserves and almost all mainstream languages now support functional style " +
                "of programming. With the introduction of lambdas in Java 8, we have new tools on our hands. In this presentation, we explore this tool and how we can benefit from it.\n" +
                "We start with an introduction to lambda and learn about imperative vs. declarative style and learn how to solve some common problems with it.', 'Venkat Subramaniam');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 35 + ", " + 6 + ", " + 21 + ", 'Core Software Design Principles', " +
                "'15:00', '16:45', " + 0 + ", 'Creating code is easy, creating good code takes a lot of time, effort, discipline, and commitment. The code we create are truly " +
                "the manifestations of our designs. Creating a lightweight design can help make the code more extensible and reusable.\n" +
                "In this presentation we will take an example oriented approach to look at some core design principles that can help us create better design and more maintainable code.', 'Venkat Subramaniam');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 36 + ", " + 1 + ", " + 11 + ", 'Panel de Java Champions Mexicanos', " +
                "'14:00', '14:45', " + 0 + ", 'Ven a este panel a conocer de primera mano el qué es un Java Champion y por qué es tan importante este rol en el ecosistema Java, escucha lo que nuestros " +
                "tres Java Champions mexicanos tienen que contarte. Por cierto, hay un Java Champion más en el evento, ¿Puedes decirnos de quién se trata?', 'Enrique Zamudio, Jorge Vargas, Andres Almiray');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 37 + ", " + 6 + ", " + 6 + ", 'Creating a Java API using TDD', " +
                "'17:00', '17:45', " + 0 + ", 'This hands-on lab walks you through the process of writing a Java API applying Test Driven Development. The main goal is to learn by example the next good software development practices:- Basic OOP design principles like cohesion and coupling.\n" +
                "- Test Driven Development. You will use JUnit and Mockito frameworks.', 'Vicente Esteban');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 38 + ", " + 7 + ", " + 15 + ", 'Tweet for Beer! Beer Tap Powered by Java Goes Internet of Things and JavaFX', " +
                "'10:00', '10:45', " + 0 + ", 'Be warned! In this session, attendees over 21 might get drunk. It demonstrates, end-to-end, how to DIY a Java-powered beer tap. " +
                "The presentation shows you a visual Java SE 8 JavaFX application running on a Raspberry Pi, a Java EE 7 application to process Twitter data and communicate " +
                "with the Raspberry Pi, and the use of complex event processing in the embedded device to warn users if they are drinking too much.', 'Bruno Borges');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 40 + ", " + 7 + ", " + 19 + ", 'Software devs guide to hardware hacking', " +
                "'12:00', '12:45', " + 0 + ", 'The world of hardware hacking has been gaining popularity recently. With the advent of open-source hardware, " +
                "there´s been tremendous interest in hacking hardware again. In this session, we´ll look at two popular hardware platforms: Arduino and RaspberryPi. " +
                "We´ll also look at how to integrate the Arduino with Android to build a cheap, complete hardware hacking platform, all written in Java!\n" +
                "We´ll go over the current open hardware scene first. Then we´ll look at how to setup these two platforms.', 'Pratik Patel');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 41 + ", " + 7 + ", " + 14 + ", 'Working with the GrovePi and Java 8', " +
                "'14:00', '14:45', " + 0 + ", 'RaspberryPi es una computadora con procesador ARM en la cual se puede ejecutar Java, lo que la diferencia de una computadora son los puertos GPIO " +
                "que permiten conectar sensores, circuitos integrados, leds, botones y muchas otras cosas más.\n" +
                "Sin embargo para conectar estos dispositivos se requiere cierto conocimiento de electronica y de los pines en la raspberry.\n" +
                "GrovePi es una placa que simplifica estas conexiones y hace que se puedan realizar prototipos de forma muy rápida y sin riesgos de hacer conexiones invalidas.\n" +
                "Esta platica se enfoca en como usar GrovePi desde Java así como los desafios que se pueden encontrar al programar con sensores y dispositivos externos usando Java.', 'Eduardo Moranchel');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 42 + ", " + 7 + ", " + 2 + ", 'Gradle, a better way to build (Charla remota)', " +
                "'11:00', '11:45', " + 0 + ", 'Are you someone who is constantly searching the globe, looking for clues on how to get maven to do your bidding? " +
                "Or perhaps you just toss a coin and hope to strike it lucky this time? Maven works OK, but there´s a new tool in town that goes beyond maven: Gradle.\n" +
                "It´s fresh, almost aerodynamic. Once you discover it, you´ll feel like you´re ´doin´ it right´ when building a project. We kid you not, it´s an " +
                "instant crush for those that have been following the path of Maven. You are in your prime as a developer, so make the most out of it by leveraging the" +
                " best tools. Oh Yeah.', 'Andres Almiray');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 43 + ", " + 7 + ", " + 2 + ", 'Big Data - The clone wars: past, present and future (Charla remota)', " +
                "'15:00', '15:45', " + 0 + ", 'Key messages about Big Data based on current developments there had been around this important circle.\n" +
                "Overview of the current project Open Data Platform vs. Apache Software Foundation, big players and the position they held. Overview of the Hadoop ecosystem, SQL and NoSQL " +
                "over Hadoop, the role of analytics and the new way to implement them: Discovery over Anticipation. \n', 'Luis Arias');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 44 + ", " + 7 + ", " + 2 + ", 'Beacons, BeaconIO', " +
                "'16:00', '16:45', " + 0 + ", 'To state the obvious: Modern, smartphone-toting humans spend most of their time indoors.\n" +
                "But indoor spaces often block cell signals and make it nearly impossible to locate devices via GPS. Beacons are a solution.\n" +
                "Beacons put the real world in contact with the Internet of Things by connecting devices with proximity awareness to the cloud.\n" +
                "They are poised to transform how retailers, event organizers, transit systems, enterprises,  and educational institutions communicate with people indoors.' , " +
                "'Oscar Vargas, Patrick Bertsch');";
        db.execSQL(sql);

        sql = "INSERT INTO " + EVENT + " VALUES (" + 45 + ", " + 7 + ", " + 2 + ", 'Big Data: From Data Ingestion to Data Analysis', " +
                "'17:00', '17:45', " + 0 + ", 'En esta sesión conoce cómo funciona un sistema de Big Data (hadoop) y cómo los analistas terminan haciendo análisis con los datos que se almacenan en él.  " +
                "Conocerás Map Reduce, Spark y desarrollo de algoritmos puestos en práctica', 'Ricardo Vasquez Sierra');";
        db.execSQL(sql);

        ///////////////////////////
        ////////////////////////////
        //////////////////////////
        //////////////////////////
        //Ponentes

        sql = "CREATE TABLE " + MEMBER + " (" + MEMBER_IDMEMBER + " INTEGER PRIMARY KEY, "
        + MEMBER_NAME + " TEXT, " + MEMBER_DETAIL + " TEXT);";
        db.execSQL(sql);

        sql = "INSERT INTO " + MEMBER + " VALUES (" + 1 + ", 'José Juan Reyes', 'Desarrollador de software y mentor en @makingdevs, podcaster en ViveCodigo.org " +
                "cofundador de GrailsMx, escritor en SpringHispano, y artesanos de software. Me gusta mucho explorar y conocer de diversas plataformas tecnológicas para " +
                "desarrollar software, aprecio mucho el conocimiento de las tendencias más importantes que proveen de diversas técnicas y métodos " +
                "que me ayuden a mejorar como profesional de software.\n" + "\n" + "Valoro mucho y tomo en consideración cada una de las aportaciones que los miembros de " +
                "las comunidades hacen en los eventos donde se presentan.\n" + "\n" +
                "Mi labor principal es crear equipos de trabajo auto organizados; considero que camino en hombros de gigantes refiriéndome a los profesionales que estén presentes en este evento.');";
       db.execSQL(sql);

//        sql = "INSERT INTO " + MEMBER + " VALUES (" + 2 + ", 'Tom McGinn', 'Tom McGinn has been involved with training and education since 1991, when he joined Sun " +
//                "Education to apply his programming background to the development of the first multimedia self-paced training courses for Solaris systems administration.\n" + "\n" +
//                "In late 1995/early 1996, Tom was tasked to co-author the first Java course for Sun.He also delivered the first commercial Java course in New York. Given the success of the " +
//                "first course, Tom began to work with other experienced instructors and engineers to build out a curriculum of several courses that covered the earliest APIs. This is the core " +
//                "Java curriculum at Oracle today.\n" +"\n" + "Recently, Tom created and ran the first Massive Open Online Course for Oracle on Java ME Embedded 8. He has developed training for Java ME, " +
//                "SE and EE. Now the manager of the Java Curriculum Development team at Oracle, he continues to push the boundaries of education and learning.');";
//        db.execSQL(sql);

        sql = "INSERT INTO " + MEMBER + " VALUES (" + 3 + ", 'Norberto Ortigoza', 'Estudie la carrera de Ingeniero en Computación en la Universidad Nacional Autónoma de Mexico. Estudie también una " +
                "maestria es ciencias de la computación con especialidad en Criptografía. Mi primer lenguaje de programación fue Smalltalk en 1992. Después estuve programando con Objetive-C y " +
                "WebObjects usando maquinas NeXt. He desarrollado sistemas en Go, Erlang, Elixir, Java, C#, PHP, Ruby, Perl, Python, C, Fortran y Pascal. He programado en sistemas Windows, " +
                "Unix BSD, Silicon Graphics, Sun, Cray y OSX.\n" +"\n" + "Durante estos 20 años he participado en diferentes roles como Administrador de sistemas, Administrador de base de datos, " +
                "Arquitecto, Consultor de procesos, Líder técnico, Líder de proyectos, Tester, Instructor, Gerente y Director.\n" + "\n" + "Actualmente soy director de TI en Diverza donde estamos desarrollando " +
                "sistemas en Rails sobre la JVM y Phoenix sobre la BEAM. También estoy como entrenador de iOS/Objective-C/Swift para Big Nerd Ranch en América Latina y estoy colaborando con Laurent Sansonetti para " +
                "promover RubyMotion.');";
        db.execSQL(sql);

        sql = "INSERT INTO " + MEMBER + " VALUES (" + 4 + ", 'Jorge Vargas', 'Jorge Vargas fue Co-Fundador y CTO de @Yumbling, una aplicación basada en Geolocalización.\n" +
                "Es uno de los fundadores de la comunidad Java Champions de Oracle.\n" +
                "Promotor activo de las comunidades de desarrolladores Java como @javaup\n" +
                "Trabaja como consultor Java desde el año 2000, y como programador desde 1992.\n" +
                "Es un orgulloso graduado del IPN & UPIICSA.\n" +
                "Actualmente está enfocado mas al sector de las telecomunicaciones y mundo mobile, diseñando y programando aplicaciones para Servicios de Valor Agregado y Backoffices.\n" +
                "Aplica, divulga y enseña los métodos ágiles como forma de vida y sobre todo de programación. Ahora prepara cosas muy interesantes en el mundo mobile.');";
        db.execSQL(sql);

        sql = "INSERT INTO " + MEMBER + " VALUES (" + 5 + ", 'Tito Sánchez', 'Tito Sanchez is an Information Technology Professional with more than 15 years of experience. " +
                "He has worked and managed international projects for different companies using java as the main technology for desktop and web applications. " +
                "Also He has taught programming courses at different schools in Mexico such as CONALEP Texcoco, Universidad Autonoma del Estado de Mexico and Universidad Politecnica de Texcoco. " +
                "Tito participated in the  ´IBFieldbook project led by Dr. Hector Sanchez-Villeda that won the Dukes Choice Award 2014.');";
        db.execSQL(sql);

        sql = "INSERT INTO " + MEMBER + " VALUES (" + 6 + ", 'Vicente Esteban', 'I am a 10+ years experience software developer that has worked for national (mexican) and\n" +
                "transnational companies. I have experience supporting existing software products both on customer´s sites and working remotely, and also developing new software products from zero.\n" +
                "\n" +
                "The projects I have been working on falls in the areas of VoIP, Manufacturing and eCommerce.\n" +
                "\n" +
                "Right now I work for Tacit Knowledge, participating in a variety of projects related with e-Commerce. Also, I participate in the recruiting process for applicants as Software Engineers.\n" +
                "\n" +
                "On my free time I enjoy playing video games with my wife and daughters and learning to play the acoustic guitar.');";
        db.execSQL(sql);

        sql = "INSERT INTO " + MEMBER + " VALUES (" + 7 + ", 'Javier Cervantes', 'Artesano del software con 8 años de experiencia. Le apasiona el desarrollo de software y crear proyectos interesante " +
                "con tecnología. Actualmente trabaja en WePow como Senior Backend Developer. Escribe código en diferentes lenguajes como Ruby, Go, Javascript, Exilir y otros. Co-organiza la comunidad " +
                "de ruby en Guadalajara y contribuye en diferentes eventos y proyectos de la ciudad.');";
        db.execSQL(sql);

        sql = "INSERT INTO " + MEMBER + " VALUES (" + 8 + ", 'Isaac Ruíz Guerra', 'Isaac Ruiz Guerra (aka RuGI).\n" +
                "Programador java desde el 2001; He participado en proyectos de distintos y muy variados alcances y áreas.\n" +
                "Me he especializado en el tema de integración de sistemas, en los últimos años he participado en proyectos fundamentalmente relacionados con el sector financiero.\n" +
                "Soy partidario del software libre y me gusta apoyarlo en la medida de mis posibilidades.\n" +
                "Creo firmemente que una manera clara de mejorar la industria del software en México es compartiendo experiencias; por ello me entusiasma la creación de comunidades libres.\n" +
                "Me encuentras en twitter, github y slideshare como: rugi\n" +
                "Participo desde hace años en:\n" +
                "http://www.javahispano.org/\n" +
                "Y, por supuesto, pertenecemos a:\n" +
                "http://www.javamexico.org/\n" +
                "Será un enorme gusto poder saludarlos personalmente en Java Dev Day. Guadalajara, MX. 2015.');";
        db.execSQL(sql);

        sql = "INSERT INTO " + MEMBER + " VALUES (" + 9 + ", 'Domingo Suárez', 'Domingo Suárez es un desarrollador con amplia experiencia en el diseño y construcción de aplicaciones " +
                "altamente escalables. Ha sido Gerente de Desarrollo en Bursatec, CTO en clickOnero y actualmente es Chief Architect en Grupo Expansión. A lo largo de su carrera ha " +
                "entrenado a más de 1,000 desarrolladores de software. Ha participado como speaker en eventos internacionales como el Grails eXchange en Londres, Spring IO en " +
                "Madrid y en el JUG de Barcelona. También es amante del café y la cerveza.');";
        db.execSQL(sql);


        sql = "INSERT INTO " + MEMBER + " VALUES (" + 11 + ", 'Enrique Zamudio', 'Enrique Zamudio desarrolla software en Java desde el 2000, especializándose en aplicaciones del lado del servidor, " +
                "tales como switches transaccionales para comercio electrónico y plataformas de pago. Enrique es parte del equipo central que desarrolla el lenguaje Ceylon desde el 2012, donde ha " +
                "hecho varias contribuciones al módulo del lenguaje, el IDE en web y el compilador JVM, además de ser el responsable del compilador de Ceylon a JavaScript. Es además el autor de los " +
                "proyectos jAlarms y j8583. Su usuario en javaMexico.org es ezamudio y su twitter es @chochosmx.');";
        db.execSQL(sql);

        sql = "INSERT INTO " + MEMBER + " VALUES (" + 12 + ", 'Eduardo Díaz', 'Eduardo es un desarrollador de software egresado del IPN; ha diseñado algunos sistemas para Telcos, el INADEM y un amigo de su primo.\n" +
                "\n" + "Tiene un gusto especial por aprender cosas nuevas (especialmente cosas sin utilidad real), UNIX, la JVM, algunos lenguajes funcionales y VIM.');";
        db.execSQL(sql);

        sql = "INSERT INTO " + MEMBER + " VALUES (" + 13 + ", 'Agustín Ramos', 'Agustín Ramos es un profesional de desarrollo de software con más de 13 años de experiencia " +
                "en la industria. Impulsor de la metáfora del artesano como un modelo de cómo podría ser nuestra profesión. Le gusta refactorizar diseños, código, ideas y equipos " +
                "de desarrollo por igual. Actualmente su principal interés se enfoca en resolver los retos que presenta el desarrollo de sistemas altamente distribuidos y escalables.');";
        db.execSQL(sql);

        sql = "INSERT INTO " + MEMBER + " VALUES (" + 14 + ", 'Andrés Almiray *', 'Andres is a Java/Groovy developer and a Java Champion with more than 16 years of experience in software design " +
                "and development. He has been involved in web and desktop application development since the early days of Java. Andres is a true believer in open source and has participated " +
                "on popular projects like Groovy, Griffon, and DbUnit, as well as starting his own projects (Json-lib, EZMorph, GraphicsBuilder, JideBuilder). Founding member of the Griffon framework " +
                "and Hackergarten community event. Spec lead for JSR377. Andres maintains a blog at http://jroller.com/aalmiray\n" +
                "\n" +
                "* Andrés estará impartiendo su plática de manera remota');";
        db.execSQL(sql);

        sql = "INSERT INTO " + MEMBER + " VALUES (" + 15 + ", 'Bruno Borges', 'Bruno Borges is Oracles Principal Product Manager for Latin America for Java Middleware Stack, " +
                "as well Java Evangelist and covers topics from Java Embedded to Java SE and JavaFX to Java EE. Bruno has more than 12 years of experience as a Java developer in several " +
                "areas, from mobile to enterprise applications.');";
        db.execSQL(sql);

        sql = "INSERT INTO " + MEMBER + " VALUES (" + 16 + ", 'Heather Vancura', 'Heather manages the JCP Program Office and is responsible for the building, supporting, and leading the community. " +
                "She oversees the JCP.org web site, JSR management and posting, community building, events, marketing, communications, and growth of the membership through new members and renewals. " +
                "Heather is the Spec Lead for JCP.Next.4, Broadening JCP Participation, and is a leader in the Global Adopt-a-JSR program with Java User Groups.  She has a front row seat for studying trends " +
                "and making improvements to engage the developer community.\n" + "\n" +
                "Several changes in recent years have included enabling broader participation, increased transparency and agility in JSR development.\n" +
                "\n" +
                "Heather develops outreach programs and events for the JCP program, including Hackergartens around the world and the community gathering at the JavaOne Conference. She enjoys speaking at conferences, such as Devoxx, FOSDEM, OSCON, and the JavaOne Conferences. She is also the author of the JCP Blog and Twitter feed (@jcp_org).');";
        db.execSQL(sql);

        sql = "INSERT INTO " + MEMBER + " VALUES (" + 17 + ", 'Oscar Vargas', 'Oscar Daniel Vargas es un Ingeniero de Software motivado por la investigación y desarrollo con nuevas tecnologías, enfocándose en plataformas móviles y especializándose en el ecosistema Android.\n" +
                "\n" +
                "Es encargado de construir aplicaciones móviles para Android y iOS en ORACLE. Docente de Programación Orientada a Objetos y Programación para Android en el ITESO, así como instructor del Diplomado de Programación para Móviles.\n" +
                "\n" +
                "Es Co-Fundador de la empresa tapatía Alpha Wave Systems.');";
        db.execSQL(sql);

        sql = "INSERT INTO " + MEMBER + " VALUES (" + 18 + ", 'Patrick Bertsch', 'Patrick Bertsch es originario de Alemania y estudio Informática en la Universidad de Ulm.\n" +
                "Antes de llegar a México era miembro de la liga de robótica llamada RoboCup (Middle-League).\n" +
                "Como miembro de los ´Ulm Sparrows´ desarrolló algoritmos con redes neuronales y Localización de Monte Carlo para que los robots aprendieran a jugar fútbol en equipo.\n" +
                "Java siempre ha sido siempre parte esencial de su carrera. Desde 2011 se dedica al desarrollo" +
                "de sistemas distribuidas y desarrollo para Android. Patrick ha trabajado en varias partes del mundo y es Co-Fundador de la empresa tapatÌa Alpha Wave Systems.');";
        db.execSQL(sql);

        sql = "INSERT INTO " + MEMBER + " VALUES (" + 19 + ", 'Patrik Patel', 'Pratik Patel is the CTO of Atlanta based TripLingo (http://www.triplingo.com/). " +
                "He wrote the first book on ´enterprise Java´ in 1996, Java Database Programming with JDBC.´ He has also spoken at various conferences and participates " +
                "in several local tech groups and startup groups. He´s in the startup world now and hacks iOS, Android, HTML5, CSS3, JavaScript, Rails, and well, everything except Perl.\n" +
                "Pratik´s specialty is in large-scale applications for mission-critical and mobile applications use. He has designed and built " +
                "applications in the retail, health care, financial services, and telecoms sectors. Pratik holds a master´s in Biomedical Engineering" +
                " from UNC, has worked in places such as New York, London, and Hong Kong, and currently lives in Atlanta, GA.');";
        db.execSQL(sql);

        sql = "INSERT INTO " + MEMBER + " VALUES (" + 20 + ", 'Reza Rahman', 'Reza Rahman is a long time former independent consultant " +
                "and now officially a Java EE evangelist at Oracle. He is the author of the popular book EJB 3 in Action. Reza is a frequent " +
                "speaker at Java User Groups and conferences worldwide including JavaOne and Devoxx. Reza is the lead for the Java EE track " +
                "at JavaOne as well as a JavaOne Rock Star Speaker award recipient. He is an avid contributor to industry journals like JavaLobby/DZone " +
                "and TheServerSide. Reza has been a member of the Java EE, EJB and JMS expert groups. He implemented the EJB container for the Resin open source " +
                "Java EE application server.\n" +"\n" +"Reza has over a decade of experience with technology leadership, enterprise architecture, " +
                "application development and consulting. He has been working with Java EE technology since its inception, developing on almost every major " +
                "application platform ranging from Tomcat to JBoss, GlassFish, WebSphere and WebLogic. Reza has developed enterprise systems for well-known companies like eBay, " +
                "Motorola, Comcast, Nokia, Prudential, Guardian Life, USAA, Independence Blue Cross and AAA using EJB 2, EJB 3, CDI, Spring and Seam.');";
        db.execSQL(sql);

        sql = "INSERT INTO " + MEMBER + " VALUES (" + 21 + ", 'Venkat Subramanian', 'Dr. Venkat Subramaniam is an award-winning author, founder of Agile " +
                "Developer, Inc., and an instructional professor at the University of Houston.\n" +"\n" +
                "He has trained and mentored thousands of software developers in the US, Canada, Europe, and Asia, and is a regularly-invited " +
                "speaker at several international conferences. Venkat helps his clients effectively apply and succeed with agile practices on their software projects.\n" +
                "\n" + "Venkat is a (co)author of multiple books, including the 2007 Jolt Productivity award winning book Practices of an " +
                "Agile Developer. His latest book is Functional Programming in Java: Harnessing the Power of Java 8 Lambda Expressions. You can " +
                "reach him by email at venkats@agiledeveloper.com or on twitter at @venkat_s.');";
        db.execSQL(sql);

        sql = "INSERT INTO " + MEMBER + " VALUES (" + 22 + ", 'Luis Arias', 'Luis Arias is an innovative, passionate, solution oriented person. " +
                "He likes reading, teaching, learning and listening to good music. His hobbies include studying languages (programming and spoken), " +
                "reading, playing music, inventing new things, walking. He has worked several years building Big Data / Business Intelligence proof of " +
                "concept solutions, besides of independently programming web platforms for several big clients mostly in Mexico City.');";
        db.execSQL(sql);

        sql = "INSERT INTO " + MEMBER + " VALUES (" + 23 + ", 'Eduardo Moranchel', 'Eduardo es Java Curriculum Developer en Oracle. " +
                "Co-Autor de 3 cursos de Java EE y JavaScript para Oracle University. Le apasiona la tecnología y el desarrollo de aplicaciones " +
                "desde móviles hasta empresariales. Miembro del Java User Group guadalajara ayuda a coordinar y preparar presentaciones donde muestra " +
                "nuevas caracteristicas y mejores prácticas para el desarrollo.');";
        db.execSQL(sql);

        sql = "INSERT INTO " + MEMBER + " VALUES (" + 24 + ", 'Ricardo Vasquez Sierra', 'Data Scientist at Ooyala');";
        db.execSQL(sql);

        sql = "INSERT INTO " + MEMBER + " VALUES (" + 25 + ", 'Pedro Hernández', 'Soy un desarrollador que ama ver crecer la cultura hacker. " +
                "Comparto mis conocimientos con las comunidades y me encanta colaborar en proyectos que conlleven la difusión de contenidos técnicos " +
                "de cálidad. Soy sensei en Dev.F, la primera hackerschool de México y lider de la comunidad GDG Androidtitlan. Me encanta la música vaporwave y el pixel art.');";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}


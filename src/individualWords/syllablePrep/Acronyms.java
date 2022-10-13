package individualWords.syllablePrep;

class Acronyms
{
  
  private static boolean isPronouncedAsWord(String word)
  {
    String acronymsPronouncedAsWords = "ADDIE|" +
      "AGRICOLA|" +
      "AIDS|" +
      "AIR|" +
      "AJAX|" +
      "ALARM|" +
      "ALERT|" +
      "ALGOL|" +
      "ANFO|" +
      "ANSI|" +
      "ANT|" +
      "APEC|" +
      "APEDS|" +
      "APEX|" +
      "APHIS|" +
      "APOLLO|" +
      "ARAG|" +
      "ARBA|" +
      "ARM|" +
      "ARPA|" +
      "ARSPACE|" +
      "ASCII|" +
      "ASTREA|" +
      "ASUN|" +
      "ASUW|" +
      "ASVEL|" +
      "ATAPI|" +
      "ATISBO|" +
      "ATLAS|" +
      "AUSCANNZUKUS|" +
      "AUSLAN|" +
      "AVCATT-A" +
      "AVUM|" +
      "AZAL|" +
      "AZUR|" +
      "BACA|" +
      "BAD|" +
      "BADD|" +
      "BAFTA|" +
      "BALCO|" +
      "BANESTO|" +
      "BANG|" +
      "BAR|" +
      "BARD|" +
      "BARDA|" +
      "BART|" +
      "BASE|" +
      "BASIC|" +
      "BAT|" +
      "BATS|" +
      "BATTERS|" +
      "BERC|" +
      "BESS|" +
      "BETS|" +
      "BEV|" +
      "BID|" +
      "BIOS|" +
      "BIT|" +
      "BITE|" +
      "BLEVE|" +
      "BLOB|" +
      "BLUFOR|" +
      "BLUI|" +
      "BOAC|" +
      "BOAT|" +
      "BOB|" +
      "BOBFOC|" +
      "BOBFOK|" +
      "BOD|" +
      "BODMAS|" +
      "BOGO|" +
      "BOGOF|" +
      "BOGSAT|" +
      "BOHICA|" +
      "BRAG|" +
      "BRASS|" +
      "BUAV|" +
      "BUG-E|" +
      "BUNO|" +
      "CAD|" +
      "CADCAM|" +
      "CADMID|" +
      "CADPAT|" +
      "CAFAD|" +
      "CAFDE|" +
      "CAFE|" +
      "CAIR|" +
      "CALL|" +
      "CALM|" +
      "CALPERS|" +
      "CALSTRS|" +
      "CAMRA|" +
      "CAN|" +
      "CANA|" +
      "CANDU|" +
      "CANOLA|" +
      "CAPES|" +
      "CARB|" +
      "CARE|" +
      "CARMONETTE|" +
      "CARP|" +
      "CART|" +
      "CASA|" +
      "CASE|" +
      "CASS|" +
      "CASTFOREM|" +
      "CASTOR|" +
      "CATS|" +
      "CATT" +
      "CAV|" +
      "CAVOK|" +
      "CECOM|" +
      "CEDEX|" +
      "CEGEP|" +
      "CENTCOM|" +
      "CENTO|" +
      "CENZUB|" +
      "CERCLA|" +
      "CERDEC|" +
      "CERGA|" +
      "CERN|" +
      "CERT|" +
      "CHAMPUS|" +
      "CHAOS|" +
      "CHAPS|" +
      "CHIP|" +
      "CHIPS|" +
      "CHOGM|" +
      "CIAO|" +
      "CISA|" +
      "CITES|" +
      "CIVETS|" +
      "CIVPOP|" +
      "CLEMARS|" +
      "CLIC|" +
      "CLOB|" +
      "CLOS|" +
      "COBOL|" +
      "COCOM|" +
      "CODA|" +
      "CODEC|" +
      "COEA|" +
      "COEIA|" +
      "COGENT|" +
      "COIL|" +
      "COIN|" +
      "COLA|" +
      "COLT|" +
      "COMECON|" +
      "COMSEC|" +
      "CONAD|" +
      "CONCACAF|" +
      "CONEMBOL|" +
      "CONOPS|" +
      "CONUS|" +
      "COPE|" +
      "COPUS|" +
      "CORBA|" +
      "CORD|" +
      "CORE|" +
      "CORG|" +
      "COROT|" +
      "COSCOM|" +
      "COSER|" +
      "COSHH|" +
      "COVID|" +
      "COVID-19|" +
      "COY|" +
      "CPAC|" +
      "CPAP|" +
      "CPEC|" +
      "CPIM|" +
      "CPIR|" +
      "CREAM|" +
      "CREB|" +
      "CREEP|" +
      "CRIPL|" +
      "CRISPR|" +
      "CSEAL|" +
      "CSERIAC|" +
      "CSICOP|" +
      "CSIP|" +
      "CSIS|" +
      "C-SPAN|" +
      "CTIS|" +
      "CUDAAP|" +
      "CUNY|" +
      "CUP|" +
      "CUPE|" +
      "CUPS|" +
      "CUREA|" +
      "CUW|" +
      "DAFIF|" +
      "DARE|" +
      "DARPA|" +
      "DART|" +
      "DAWN|" +
      "DECA|" +
      "DEERS|" +
      "DEFCON|" +
      "DINA|" +
      "DINKY|" +
      "DIPS|" +
      "DISA|" +
      "DISCOM|" +
      "DISE|" +
      "DISSTAF|" +
      "DIVAD|" +
      "DODAF|" +
      "DODEA|" +
      "DORA|" +
      "DOTA|" +
      "DUMBO|" +
      "DVOM|" +
      "EAST|" +
      "ECHO|" +
      "EDGAR|" +
      "EGRET|" +
      "ELF|" +
      "ELINT|" +
      "EMBRAER|" +
      "EMCON|" +
      "EMDEX|" +
      "ENCODE|" +
      "ENSATT|" +
      "ENTEC|" +
      "EOSAT|" +
      "EOSDIS|" +
      "EPCOT|" +
      "EROS|" +
      "ESPGHAN|" +
      "ETOPS|" +
      "EUCOM|" +
      "EVIL|" +
      "FACA|" +
      "FACS|" +
      "FACTS|" +
      "FAFSA|" +
      "FAPA|" +
      "FAPHA|" +
      "FARP|" +
      "FASCAM|" +
      "FASEB|" +
      "FAST|" +
      "FEAR|" +
      "FEAST|" +
      "FEATS|" +
      "FEBA|" +
      "FEDEP|" +
      "FEMA|" +
      "FENS|" +
      "FIBA|" +
      "FIFA|" +
      "FIFE|" +
      "FOFO|" +
      "FIFRA|" +
      "FIG|" +
      "FILA|" +
      "FILO|" +
      "FIMPT|" +
      "FINA|" +
      "FIPS|" +
      "FIRES|" +
      "FISA|" +
      "FISH|" +
      "FIST|" +
      "FITS|" +
      "FLAC|" +
      "FLAK|" +
      "FLET|" +
      "FLIP|" +
      "FLIR|" +
      "FLOT|" +
      "FLTSAT|" +
      "FLTSATCOM|" +
      "FMECA|" +
      "FOAF|" +
      "FOMO|" +
      "FONSI|" +
      "FORTRAN|" +
      "FOTA|" +
      "FOOP|" +
      "FRAGO|" +
      "FRAND|" +
      "FUBAR|" +
      "GAAR|" +
      "GALCIT|" +
      "GEBCO|" +
      "GEEP|" +
      "GEICO|" +
      "GEMA|" +
      "GESTAPO|" +
      "GIF|" +
      "GIGO|" +
      "GIMP|" +
      "GLAAD|" +
      "GLAST|" +
      "GLINT|" +
      "GLONASS|" +
      "GLUT|" +
      "GMAC|" +
      "GNOME|" +
      "GNU|" +
      "GOAT|" +
      "GOES|" +
      "GORP|" +
      "GOSH|" +
      "GOSP|" +
      "GOTS|" +
      "GOWI|" +
      "GOYADIN|" +
      "GPID|" +
      "GRAIL|" +
      "GRAS|" +
      "GREP|" +
      "GRID|" +
      "GRIT|" +
      "GRU|" +
      "GUI|" +
      "GUILT|" +
      "GULAG|" +
      "GUM|" +
      "GUT|" +
      "GWAS|" +
      "GWOT|" +
      "HAARP|" +
      "HAART|" +
      "HAL|" +
      "HALO|" +
      "HALT|" +
      "HANS|" +
      "HARM|" +
      "HAT|" +
      "HAW|" +
      "HAWK|" +
      "HAZMAT|" +
      "HEAT|" +
      "HEBA|" +
      "HEER|" +
      "HELOC|" +
      "HEMP|" +
      "HEPA|" +
      "HESH|" +
      "HETT|" +
      "HEWITTS|" +
      "HFAC|" +
      "HIMAD|" +
      "HIMEZ|" +
      "HIPAA|" +
      "HIPPARCOS|" +
      "HIRD|" +
      "HIRISE|" +
      "HLOS|" +
      "HOLLAND|" +
      "HOMES|" +
      "HONY|" +
      "HOPI|" +
      "HORECA|" +
      "HORIZON|" +
      "HOSTAC|" +
      "HOT|" +
      "HOTAS|" +
      "HOTT|" +
      "HUD|" +
      "HUF|" +
      "HUMINT|" +
      "HUMVEE|" +
      "HURD|" +
      "HVAC|" +
      "HVAP|" +
      "IACREOT|" +
      "ICHTHYS|" +
      "ICRAF|" +
      "ICRISAT|" +
      "IDEA|" +
      "IFAB|" +
      "IFAP|" +
      "IFOR|" +
      "IGNOU|" +
      "IHOP|" +
      "IKEA|" +
      "IMPAC|" +
      "IMPACT|" +
      "IPMATT|" +
      "INCITS|" +
      "INDIGO|" +
      "INFORMS|" +
      "INFOSEC|" +
      "INLA|" +
      "INMARSET|" +
      "INRIA|" +
      "INSAR|" +
      "INTSUM|" +
      "INTERFET|" +
      "IOLTA|" +
      "IRAN|" +
      "IREA|" +
      "IRO|" +
      "ISAF|" +
      "ISAR|" +
      "ISCII|" +
      "ISEF|" +
      "ISEN|" +
      "ISIL|" +
      "ISIS|" +
      "ISTAR|" +
      "ITAG|" +
      "ITALY|" +
      "ITAS|" +
      "ITEC|" +
      "ITEMS|" +
      "ITER|" +
      "ITTO|" +
      "IUPAC|" +
      "IUPUI|" +
      "IVECO|" +
      "IVIS|" +
      "IWARS|" +
      "JABODETABEK|" +
      "JAMA|" +
      "JANET|" +
      "JANUS|" +
      "JATO|" +
      "JCIDS|" +
      "JCIET|" +
      "JDAM|" +
      "JDEM|" +
      "JET|" +
      "JFACC|" +
      "JFACTSU|" +
      "JFCOM|" +
      "JFET|" +
      "JFSOCC|" +
      "JINI|" +
      "JITC|" +
      "JIVE|" +
      "JOFA|" +
      "JOPES|" +
      "JOTS|" +
      "JPEG|" +
      "JPOW|" +
      "JREF|" +
      "JROC|" +
      "JROCM|" +
      "JSAF|" +
      "JSEAD|" +
      "JSTARS|" +
      "JTAG|" +
      "JTAGS|" +
      "JTENS|" +
      "JTIDS|" +
      "JUGFET|" +
      "JUICE|" +
      "KANUKOKA|" +
      "KARNAC|" +
      "KARR|" +
      "KATUSA|" +
      "KEDO|" +
      "KERA|" +
      "KERMA|" +
      "KESR|" +
      "KFOR|" +
      "KIDS|" +
      "KISS|" +
      "KITECH|" +
      "KITT|" +
      "KLENOT|" +
      "KLOC|" +
      "LABVIEW|" +
      "LACMA|" +
      "LAESI|" +
      "LAMP|" +
      "LAN|" +
      "LARC|" +
      "LARP|" +
      "LASER|" +
      "LATA|" +
      "LATCH|" +
      "LCOL|" +
      "LDAP|" +
      "LDMOS|" +
      "LEGS|" +
      "LEGAD|" +
      "LEMOSS|" +
      "LIBOR|" +
      "LIFO|" +
      "LIGO|" +
      "LINEAR|" +
      "LISA|" +
      "LITAS|" +
      "LIVE|" +
      "LOFAR|" +
      "LOGPAC|" +
      "LOMEX|" +
      "LONEOS|" +
      "LOOGY|" +
      "LORTID|" +
      "LOSAT|" +
      "LOTA|" +
      "LOTIS|" +
      "LOTS|" +
      "LRIP|" +
      "LSAT|" +
      "LSIF|" +
      "LUCA|" +
      "LULU|" +
      "MACA|" +
      "MACE|" +
      "MACHO|" +
      "MADD|" +
      "MAFF|" +
      "MAGIC|" +
      "MAGNETAR|" +
      "MAHASZ|" +
      "MANPADS|" +
      "MANPRINT|" +
      "MAPP|" +
      "MAPPS|" +
      "MARBEF|" +
      "MARC|" +
      "MARCENT|" +
      "MARFORCC|" +
      "MARRS|" +
      "MASAS|" +
      "MASER|" +
      "MASH|" +
      "MASINT|" +
      "MATREX|" +
      "MATS|" +
      "MAVS|" +
      "MAX|" +
      "MEAC|" +
      "MECCA|" +
      "MECO|" +
      "MEDEVAC|" +
      "MEDLI|" +
      "MENA|" +
      "MESSENGER|" +
      "METAR|" +
      "METOC|" +
      "MICE|" +
      "MICLIC|" +
      "MICOM|" +
      "MIDI|" +
      "MIDAS|" +
      "MIKE|" +
      "MILAASPEM|" +
      "MILAN|" +
      "MILES|" +
      "MILSATCOM|" +
      "MILSET|" +
      "MILSTRIP|" +
      "MIMAROPA|" +
      "MIMOSA|" +
      "MIRA|" +
      "MISREP|" +
      "MISSI|" +
      "MOAB|" +
      "MODAF|" +
      "MODEM|" +
      "MODSAF|" +
      "MOFA|" +
      "MOID|" +
      "MOLO|" +
      "MOMA|" +
      "MOPE|" +
      "MOPP|" +
      "MORP|" +
      "MOSFET|" +
      "MOSS|" +
      "MOTA|" +
      "MOTESS|" +
      "MOTO|" +
      "MOVES|" +
      "MPEC|" +
      "MPEG|" +
      "MPEV|" +
      "MSEC|" +
      "MWESH|" +
      "NAVISA|" +
      "NACMA|" +
      "NACRA|" +
      "NAFO|" +
      "NAFTA|" +
      "NAGPRA|" +
      "NAICS|" +
      "NAIL|" +
      "NAILS|" +
      "NAIRU|" +
      "NAMBLA|" +
      "NAPS|" +
      "NARA|" +
      "NARAL|" +
      "NARDAC|" +
      "NARDIC|" +
      "NARP|" +
      "NASA|" +
      "NASCAR|" +
      "NASDAQ|" +
      "NASED|" +
      "NASH|" +
      "NASS|" +
      "NATGEO|" +
      "NATO|" +
      "NAUKMA|" +
      "NAVCAMS|" +
      "NAVCENT|" +
      "NAVDAC|" +
      "NAVEUR|" +
      "NAVFE|" +
      "NAVFOR|" +
      "NAVMACS|" +
      "NAVNET|" +
      "NAVSAT|" +
      "NAVSPACECOM|" +
      "NAVSPASUR|" +
      "NAVSTAR|" +
      "NAVTACNET|" +
      "NAWIRA|" +
      "NAWMP|" +
      "NBACC|" +
      "NDOF|" +
      "NECTEC|" +
      "NEPA|" +
      "NERF|" +
      "NERICA|" +
      "NESDIS|" +
      "NESST|" +
      "NETCU|" +
      "NETWARS|" +
      "NGATS|" +
      "NHANES|" +
      "NIAID|" +
      "NICA|" +
      "NICAP|" +
      "NICE|" +
      "NIMA|" +
      "NIMBY|" +
      "NIMH|" +
      "NIOSH|" +
      "NISAC|" +
      "NISCAP|" +
      "NISER|" +
      "NLIC|" +
      "NMOS|" +
      "NOAF|" +
      "NODEF|" +
      "NOFEAR|" +
      "NOLA|" +
      "NOGI|" +
      "NOLF|" +
      "NOME|" +
      "NOMBO|" +
      "NOPA|" +
      "NORAD|" +
      "NORCECA|" +
      "NORELPREF|" +
      "NORTHAG|" +
      "NOSA|" +
      "NOTAFLOF|" +
      "NOTAM|" +
      "NUTS|" +
      "OARSI|" +
      "OASIS|" +
      "OBOR|" +
      "OCIDS|" +
      "OCONUS|" +
      "OCOKA|" +
      "ODAS|" +
      "ONCE|" +
      "ONERA|" +
      "OPAC|" +
      "OPCON|" +
      "OPEC|" +
      "OPFOR|" +
      "OPLAN|" +
      "OPORD|" +
      "OPSEC|" +
      "OPSEC|" +
      "OPSI|" +
      "OPTAR|" +
      "ORBAT|" +
      "ORISE|" +
      "OSERS|" +
      "OSETI|" +
      "OSGEO|" +
      "OSIA|" +
      "OSIRIS|" +
      "OSPA|" +
      "PACER|" +
      "PACOM|" +
      "PADD|" +
      "PADI|" +
      "PAHO|" +
      "PAMIDA|" +
      "PAMELA|" +
      "PAPI|" +
      "PAROS|" +
      "PARWIG|" +
      "PASA|" +
      "PATH|" +
      "PAWS|" +
      "PAYD|" +
      "PAYE|" +
      "PEBCAC|" +
      "PEBKAC|" +
      "PEEK|" +
      "PEET|" +
      "PEGIDA|" +
      "PEPFAR|" +
      "PERM|" +
      "PEST|" +
      "PETA|" +
      "PFLAG|" +
      "PFIY|" +
      "PGENI|" +
      "PICNIC|" +
      "PIDOOMA|" +
      "PIGS|" +
      "PIPA|" +
      "PIRA|" +
      "PIREPS|" +
      "PITA|" +
      "PITS|" +
      "PLAID|" +
      "PLEBS|" +
      "PLOKTA|" +
      "PLUTO|" +
      "PMOS|" +
      "PNAC|" +
      "PNG|" +
      "POETS|" +
      "POGO|" +
      "POLAD|" +
      "QANTAS|" +
      "QSCAT|" +
      "QSTAG|" +
      "QUANGO|" +
      "QUASAR|" +
      "QUIET|" +
      "RABOBANK|" +
      "RACK|" +
      "RACON|" +
      "RADA|" +
      "RADAR|" +
      "RAGBRAI|" +
      "RAPIDS|" +
      "RARDE|" +
      "RARE|" +
      "RATELO|" +
      "RBAR|" +
      "RCAR|" +
      "REACH|" +
      "REACT|" +
      "REAM|" +
      "RECCE|" +
      "REEF|" +
      "REM|" +
      "REME|" +
      "RESNA|" +
      "RIBA|" +
      "RIFA|" +
      "RILA|" +
      "RINO|" +
      "RISTA|" +
      "ROME|" +
      "ROPE|" +
      "RORO|" +
      "ROWPU|" +
      "ROYGIBV|" +
      "RSEQ|" +
      "RUBISCO|" +
      "SAAFR|" +
      "SAAMI|" +
      "SAARC|" +
      "SABENA|" +
      "SABIC|" +
      "SACAT|" +
      "SACEUR|" +
      "SACLANT|" +
      "SACLOS|" +
      "SADD|" +
      "SADL|" +
      "SAFER|" +
      "SAFETY|" +
      "SAFICT|" +
      "SAGAT|" +
      "SAGE|" +
      "SALT|" +
      "SAMBO|" +
      "SANZAAR|" +
      "SARA|" +
      "SART|" +
      "SARU|" +
      "SASE|" +
      "SASO|" +
      "SASOL|" +
      "SATNAV|" +
      "SAVAK|" +
      "SAWS|" +
      "SCHIMS|" +
      "SCHIP|" +
      "SCOTUS|" +
      "SCRAM|" +
      "SCUBA|" +
      "SEADI|" +
      "SEAFDEC|" +
      "SEAL|" +
      "SEAT|" +
      "SEATO|" +
      "SEAWIFS|" +
      "SECAAS|" +
      "SECAM|" +
      "SECDEF|" +
      "SEDRIS|" +
      "SELKENT|" +
      "SELT|" +
      "SEPTA|" +
      "SESSPE|" +
      "SETI|" +
      "SETAC|" +
      "SHAC|" +
      "SHAPE|" +
      "SHOALS|" +
      "SHORAD|" +
      "SHORADEZ|" +
      "SIDS|" +
      "SIDU|" +
      "SIFF|" +
      "SIGCAT|" +
      "SIGINT|" +
      "SIGMET|" +
      "SIMAC|" +
      "SIMLAS|" +
      "SIMM|" +
      "SIMNET|" +
      "SIMNETD|" +
      "SIMP|" +
      "SIMPLE|" +
      "SINCGARS|" +
      "SIPP|" +
      "SIRI|" +
      "SIRS|" +
      "SISO|" +
      "SLAC|" +
      "SLAN|" +
      "SLAPP|" +
      "SLIT|" +
      "SLOC|" +
      "SLORC|" +
      "SMART|" +
      "SMASS|" +
      "SMIL|" +
      "SNAFU|" +
      "SNAP|" +
      "SNOBOL|" +
      "SOAP|" +
      "SOCCSKSARGEN|" +
      "SOCOM|" +
      "SOCON|" +
      "SOFIA|" +
      "SOGAT|" +
      "SOHO|" +
      "SOLIS|" +
      "SONAR|" +
      "SOSTAR|" +
      "SOUTHAG|" +
      "SOUTHCOM|" +
      "SOWHAT|" +
      "SPAAG|" +
      "SPAC|" +
      "SPACECOM|" +
      "SPAL|" +
      "SPASER|" +
      "SPEAC|" +
      "SPECTRE|" +
      "SPEAR|" +
      "SPEED|" +
      "SPIE|" +
      "SPOD|" +
      "SPOE|" +
      "SPOT|" +
      "SQUID|" +
      "SRAM|" +
      "STAG|" +
      "STAGE|" +
      "STANAG|" +
      "STAR|" +
      "STAT|" +
      "STEM|" +
      "STENTOR|" +
      "STRATCOM|" +
      "STRICOM|" +
      "STRIVE|" +
      "STUKA|" +
      "SUNY|" +
      "SURTASS|" +
      "SUSAT|" +
      "SWAC|" +
      "SWALK|" +
      "SWAN|" +
      "SWAP|" +
      "SWAPO|" +
      "SWAT|" +
      "SWIG|" +
      "SWIR|" +
      "SWORD|" +
      "SWORDS|" +
      "SWOT|" +
      "SWP|" +
      "SYSOP|" +
      "TAACOM|" +
      "TAADCOORD|" +
      "TACAMO|" +
      "TACAN|" +
      "TACC|" +
      "TACCO|" +
      "TACDAR|" +
      "TACSOP|" +
      "TADIL|" +
      "TADL|" +
      "TADSS|" +
      "TALES|" +
      "TANSTAAFL|" +
      "TAPPS|" +
      "TARDIS|" +
      "TARP|" +
      "TAROT|" +
      "TASER|" +
      "TCAS|" +
      "TEAL|" +
      "TEAM|" +
      "TEAMS|" +
      "TED|" +
      "TEEL|" +
      "TEETH|" +
      "TELAR|" +
      "TEMO|" +
      "TENCAP|" +
      "TERS|" +
      "TEST|" +
      "TEVES|" +
      "THAAD|" +
      "THEGENTRY|" +
      "THEL|" +
      "TIALD|" +
      "TIBS|" +
      "TIGERS|" +
      "TIMS|" +
      "TINC|" +
      "TINY|" +
      "TLAM|" +
      "TLAR|" +
      "TMAP|" +
      "TOAD|" +
      "TOBS|" +
      "TODO|" +
      "TOGS|" +
      "TOMS|" +
      "TRACON|" +
      "TRADOC|" +
      "TRAIN|" +
      "TRANSCOM|" +
      "TRAP|" +
      "TRASANA|" +
      "TRIGAT|" +
      "TRIPS|" +
      "TRUEX|" +
      "TSEC|" +
      "TSOP|" +
      "TWAIN|" +
      "UBIGEO|" +
      "UDOT|" +
      "UKIP|" +
      "ULEB|" +
      "ULOF|" +
      "UTOP|" +
      "UNABOM|" +
      "UNAIDS|" +
      "UNAM|" +
      "UNAMSIL|" +
      "UNCLOS|" +
      "UNCTAD|" +
      "UNEP|" +
      "UNESCO|" +
      "UNICEF|" +
      "UNICRI|" +
      "UNIDO|" +
      "UNIFEM|" +
      "UNIS|" +
      "UNMIK|" +
      "UNMOVIC|" +
      "UNOSOM|" +
      "UNPROFOR|" +
      "UNTAC|" +
      "UNTAET|" +
      "USAF|" +
      "USAACE|" +
      "USAADAC|" +
      "USAAS|" +
      "USAIC|" +
      "USAID|" +
      "USAP|" +
      "USAPATRIOT|" +
      "USAREUR|" +
      "USEC|" +
      "USNOFS|" +
      "USSPACECOM|" +
      "USTRANSCOM|" +
      "UTEP|" +
      "VACIS|" +
      "VACUUM|" +
      "VANOS|" +
      "VASIS|" +
      "VAT|" +
      "VEEGA|" +
      "VERDI|" +
      "VERITAS|" +
      "VIDS|" +
      "VISCII|" +
      "VIVO|" +
      "VLAD|" +
      "VOIP|" +
      "VOLT|" +
      "VOLVO|" +
      "VOX|" +
      "VROTS|" +
      "VSAT|" +
      "VSHORAD|" +
      "VSOP|" +
      "VISTOL|" +
      "VTEC|" +
      "VTOL|" +
      "WACC|" +
      "WACS|" +
      "WAGGGS|" +
      "WAGMI|" +
      "WAGS|" +
      "WAN|" +
      "WAP|" +
      "WAPIMA|" +
      "WAR|" +
      "WASP|" +
      "WAYP|" +
      "WEBS|" +
      "WEC|" +
      "WEIRD|" +
      "WHAM|" +
      "WHIP|" +
      "WHO|" +
      "WIMP|" +
      "WIPO|" +
      "WIPP|" +
      "WMANUS|" +
      "WOLOG|" +
      "WOW|" +
      "WRAIR|" +
      "WYSIWYG|" +
      "WYSIWYP|" +
      "YAFLA|" +
      "YABSLAG|" +
      "YILP|" +
      "YOLO|" +
      "ZAMS|" +
      "ZIP|" +
      "ZIRP|" +
      "ZOPFAN|" +
      "ZUG|" +
      "ZUI|" +
      "Z+";
      
//    String testy = "YILP|" +
//      "YOLO";
    
    if (word.matches(acronymsPronouncedAsWords))
    {
      return true;
    }
    else
    {
      return false;
    }
    
    
    
//    Pattern pattern = Pattern.compile(acronymsPronouncedAsWords);
//    Matcher matcher = pattern.matcher(word);
//
//    
//    if (matcher.find())
//    {
//      return true;
//    }
//    else
//    {
//      return false;
//    }
  }

  static String detectAcronyms(String wordToCheck)
  {
    String word = wordToCheck;
    
    if (word.equals(wordToCheck.toUpperCase()) && isPronouncedAsWord(word) == false)
    {
      String hyphenatedWord = "";
      
      for (int i = 0; i < word.length(); i++ )
      {
        hyphenatedWord = hyphenatedWord + "-" + word.charAt(i);
      }
      
      word = hyphenatedWord;
    }
    
//    System.out.println(word);
    return word;
  }
  
  public static void main(String[] args)
  {
    detectAcronyms("BUZZ");


  }
}

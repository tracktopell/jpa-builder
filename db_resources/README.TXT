mvn -f ../../tracktopell/jpa-builder/pom.xml install && ant GENERATE_ALL_SQL GENERATE_SRC_MVN INIT_DB_DEV -Dadmin.db.user=root  -Dadmin.db.password=root
mvn -f ../../tracktopell/jpa-builder/pom.xml install && ant GENERATE_ALL_SQL INIT_DB_DEV -Dadmin.db.user=root  -Dadmin.db.password=root
mvn -f ../../tracktopell/jpa-builder/pom.xml install && ant GENERATE_ALL_SQL GENERATE_SRC_MVN 
mvn -f ../../tracktopell/jpa-builder/pom.xml install && ant GENERATE_SRC_MVN 

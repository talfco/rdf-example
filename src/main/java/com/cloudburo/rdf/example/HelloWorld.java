package com.cloudburo.rdf.example;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.sparql.vocabulary.FOAF;


public class HelloWorld {
    public static void main(String... argvs) {
        Model model = ModelFactory.createDefaultModel(); 
        // Retrieve a URL corresponding to RDF Schema vocabulary in RDF/XML format
        //model.read("https://www.w3.org/TR/2002/WD-rdf-schema-20020430/rdfs-namespace.xml", null, "RDF/XML");
        //model.write(System.out, "TURTLE");
        model.createResource("http://example.org/alice", FOAF.Person)
            .addProperty(FOAF.name, "Alice")
            .addProperty(FOAF.mbox, model.createResource("mailto:alice@example.org"))
            .addProperty(FOAF.knows, model.createResource("http://example.org/bob"));

        model.write(System.out, "RDF/XML");
    }
}

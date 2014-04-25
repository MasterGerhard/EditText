/*
 *  JOrtho
 *
 *  Copyright (C) 2005-2008 by i-net software
 *
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU General Public License as 
 *  published by the Free Software Foundation; either version 2 of the
 *  License, or (at your option) any later version. 
 *
 *  This program is distributed in the hope that it will be useful, but
 *  WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *  General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 *  USA.
 *  
 * Created on 13.12.2007
 */
package JOrtho.com.inet.jorthodictionaries;

import java.util.Properties;
import java.util.StringTokenizer;

/**
 * 
 * @author Volker Berlin
 */
public class BookGenerator_es extends BookGenerator {

    @Override
    boolean isValidLanguage( String word, String wikiText ) {
        if( wikiText.indexOf( "{{ES}}" ) < 0 && wikiText.indexOf( "{{ES|" ) < 0 ) {
            return false;
        }

        //the follow rules can be found at http://es.wiktionary.org/wiki/Categor%C3%ADa:ES:Plantillas_de_flexi%C3%B3n

        //http://es.wiktionary.org/wiki/Categor%C3%ADa:ES:Plantillas_de_flexi%C3%B3n_de_adjetivos
        findRuleAndAddWords( word, wikiText, "inflect.es.adj.-n", null, new String[] { "n", "ona", "ones", "onas" } ); //redirect to inflect.es.adj.agudo-cons
        findRuleAndAddWords( word, wikiText, "inflect.es.adj.agudo-cons", null, new String[] { "n", "ona", "ones", "onas" } );
        findRuleAndAddWords( word, wikiText, "inflect.es.adj.ad-lib", null, new String[] { "" }, new String[] { "" }, new String[] { "" }, new String[] { "" } );
        findRuleAndAddWords( word, wikiText, "inflect.es.adj.no-gnero", new String[] { "s" } );
        findRuleAndAddWords( word, wikiText, "inflect.es.adj.reg", null, new String[] { "o", "os", "a", "as" } );
        findRuleAndAddWords( word, wikiText, "inflect.es.adj.reg-cons", new String[] { "es", "a", "as" } );

        //http://es.wiktionary.org/wiki/Categor%C3%ADa:ES:Plantillas_de_flexi%C3%B3n_de_sustantivos
        findRuleAndAddWords( word, wikiText, "inflect.es.sust.-n", null, new String[] { "n", "ones" } ); //redirect to inflect.es.sust.agudo-cons
        findRuleAndAddWords( word, wikiText, "inflect.es.sust.agudo-cons", null, new String[] { "n", "ones" } );
        //inflect.es.sust.invariante nothing
        //inflect.es.sust.plur.tantum nothing
        findRuleAndAddWords( word, wikiText, "inflect.es.sust.reg", new String[] { "s" } );
        findRuleAndAddWords( word, wikiText, "inflect.es.sust.reg-cons", new String[] { "es" } );
        //{{inflect.es.sust.sing.tantum}} nothing

        //http://es.wiktionary.org/wiki/Categor%C3%ADa:ES:Plantillas_de_flexi%C3%B3n_de_verbos
        findRuleAndAddWords( word, wikiText, "es.v.conj.ar", null, new String[] { "ar", "ado", "ando", "o", "as", "s", "a", "amos", "is",
                        "an", "aba", "abas", "bamos", "abais", "aban", "", "aste", "", "asteis", "aron", "ar", "ars", "ar", "aremos",
                        "aris", "arn", "ara", "aras", "aramos", "arais", "aran", "e", "es", "s", "emos", "is", "en", "ara",
                        "aras", "ramos", "arais", "aran", "ase", "ases", "semos", "aseis", "asen", "are", "ares", "remos", "areis",
                        "aren", "", "emos", "ad" } );
        findRuleAndAddWords( word, wikiText, "es.v.conj.2.ar", null, new String[] { "ar", "ado", "ando", "s", "amos", "is", "aba",
                        "abas", "bamos", "abais", "aban", "", "aste", "", "asteis", "aron", "ar", "ars", "ar", "aremos", "aris",
                        "arn", "ara", "aras", "aramos", "arais", "aran", "s", "emos", "is", "ara", "aras", "ramos", "arais",
                        "aran", "ase", "ases", "semos", "aseis", "asen", "are", "ares", "remos", "areis", "aren", "", "emos", "ad" }, new String[] {
                        "o", "as", "a", "an", "e", "es", "en" } );
        findRuleAndAddWords( word, wikiText, "es.v.conj.car", null, new String[] { "car", "cado", "cando", "co", "cas", "cs", "ca",
                        "camos", "cis", "can", "caba", "cabas", "cbamos", "cabais", "caban", "qu", "caste", "c", "casteis", "caron",
                        "car", "cars", "car", "caremos", "caris", "carn", "cara", "caras", "caramos", "carais", "caran", "que",
                        "ques", "qus", "quemos", "quis", "quen", "cara", "caras", "cramos", "carais", "caran", "case", "acses",
                        "csemos", "caseis", "casen", "care", "cares", "cremos", "careis", "caren", "c", "quemos", "cad" } );
        findRuleAndAddWords( word, wikiText, "es.v.conj.cuar", null, new String[] { "cuar", "cuado", "cuando", "cuo", "co", "cuas",
                        "cas", "cua", "ca", "cuamos", "cuis", "cuan", "can", "cuaba", "cuabas", "cubamos", "cuabais", "cuaban", "cu",
                        "cuaste", "cu", "cuasteis", "cuaron", "cuar", "cuars", "cuar", "cuaremos", "cuaris", "cuarn", "cuara",
                        "cuaras", "cuaramos", "cuarais", "cuaran", "cue", "ce", "cues", "ces", "cuemos", "cuis", "cuen", "cen",
                        "cuara", "cuaras", "curamos", "cuarais", "cuaran", "cuase", "cuases", "cusemos", "cuaseis", "cuasen", "cuare",
                        "cuares", "curemos", "cuareis", "cuaren", "cua", "ca", "cuemos", "cuad" } );
        //TODO es.v.conj.dar (0)
        findRuleAndAddWords( word, wikiText, "es.v.conj.gar", null, new String[] { "gar", "gado", "gando", "go", "gas", "gs", "ga",
                        "gamos", "gis", "gan", "gaba", "gabas", "gbamos", "gabais", "gaban", "gu", "gaste", "g", "gasteis", "garon",
                        "gar", "gars", "gar", "garemos", "garis", "garn", "gara", "garas", "garamos", "garais", "garan", "gue",
                        "gues", "gus", "guemos", "guis", "guen", "gara", "garas", "gramos", "garais", "garan", "gase", "gases",
                        "gsemos", "gaseis", "gasen", "gare", "gares", "gremos", "gareis", "garen", "g", "guemos", "gad" } );
        //TODO es.v.conj.guar (12)
        findRuleAndAddWords( word, wikiText, "es.v.conj.-ie-ue-.ar", null, new String[] { "ar", "ado", "ando", "s", "amos", "is", "aba",
                        "abas", "bamos", "abais", "aban", "", "aste", "", "asteis", "aron", "ar", "ars", "ar", "aremos", "aris",
                        "arn", "ara", "aras", "aramos", "arais", "aran", "s", "emos", "is", "ara", "aras", "ramos", "arais",
                        "aran", "ase", "ases", "semos", "aseis", "asen", "are", "ares", "remos", "areis", "aren", "", "emos", "ad" }, new String[] {
                        "o", "as", "a", "an", "e", "es", "en" } );
        //TODO es.v.conj.-ie-ue-.gar (23)
        //TODO es.v.conj.-ie-ue-.zar (8)
        //TODO es.v.conj.izar (7)
        findRuleAndAddWords( word, wikiText, "es.v.conj.zar", null, new String[] { "zar", "zado", "zando", "zo", "zas", "zs", "za",
                        "zamos", "zis", "zan", "zaba", "zabas", "zbamos", "zabais", "zaban", "c", "zaste", "z", "zasteis", "zaron",
                        "zar", "zars", "zar", "azremos", "zaris", "zarn", "zara", "zaras", "zaramos", "zarais", "zaran", "ce",
                        "ces", "cs", "cemos", "cis", "cen", "zara", "zaras", "zramos", "zarais", "zaran", "zase", "zases", "zsemos",
                        "zaseis", "zasen", "zare", "zares", "zremos", "zareis", "zaren", "z", "cemos", "zad" } );
        //TODO es.v.conj.andar (1)

        es_v_conj_er( wikiText );
        es_v_conj_ie_ue_er( wikiText );
        es_v_conj_cer( wikiText );
        es_v_conj_zc_cer( wikiText );
        es_v_conj_eer( wikiText );
        es_v_conj_ger( wikiText );
        es_v_conj_caer( wikiText );
        es_v_conj_hacer( wikiText );
        es_v_conj_poner( wikiText );
        es_v_conj_tener( wikiText );
        es_v_conj_traer( wikiText );

        es_v_conj_ir( wikiText );
        es_v_conj_cir( wikiText );
        es_v_conj_zc_cir( wikiText );
        es_v_conj_decir( wikiText );
        es_v_conj_gir( wikiText );
        es_v_conj_ie_i_ue_ir( wikiText );
        es_v_conj_nir( wikiText );
        es_v_conj_seguir( wikiText );
        es_v_conj_uir( wikiText );

        return true;
    }

    /**
     * http://es.wiktionary.org/w/index.php?title=Plantilla:es.v.conj.-ie-ue-.er&action=edit
     * @param wikiText the completely wiki text
     */
    private void es_v_conj_ie_ue_er( String wikiText ) {
        Properties props = BookUtils.parseRule( wikiText, "es.v.conj.-ie-ue-.er", 0 );

        if( props != null ) {
            String nexo = props.getProperty( "nexo", "" );
            String w2 = props.getProperty( "2", "{{{2}}}" );
            boolean pronominal = props.getProperty( "pronominal", "" ).length() > 0;

            //presente de indicativo
            props.setProperty( "i.p.1s", w2 + nexo + "o" );
            props.setProperty( "i.p.2s", w2 + nexo + "es" );
            props.setProperty( "i.p.3s", w2 + nexo + "e" );
            props.setProperty( "i.p.3p", w2 + nexo + "en" );

            //presente de subjuntivo
            props.setProperty( "s.p.1s", w2 + nexo + "a" );
            props.setProperty( "s.p.2s", w2 + nexo + "as" );
            props.setProperty( "s.p.3s", w2 + nexo + "a" );
            props.setProperty( "s.p.3p", w2 + nexo + "an" );

            //imperativo
            props.setProperty( "im.2s", pronominal ? (props.getProperty( "3", "{{{3}}}" ) + nexo + "ete") : (w2 + nexo + "e") );

            es_v_conj_er( props );
        }
    }

    /**
     * http://es.wiktionary.org/w/index.php?title=Plantilla:es.v.conj.er&action=edit
     * @param wikiText the completely wiki text
     */
    private void es_v_conj_er( String wikiText ) {
        Properties props = BookUtils.parseRule( wikiText, "es.v.conj.er", 0 );
        if( props != null ) {
            es_v_conj_er( props );
        }
    }

    /**
     * http://es.wiktionary.org/w/index.php?title=Plantilla:es.v.conj.cer&action=edit
     * @param wikiText the completely wiki text
     */
    private void es_v_conj_cer( String wikiText ) {
        Properties props = BookUtils.parseRule( wikiText, "es.v.conj.cer", 0 );
        if( props != null ) {
            props.put( "nexo", "c" );
            es_v_conj_er( props );
        }
    }

    /**
     * http://es.wiktionary.org/w/index.php?title=Plantilla:es.v.conj.zc.cer&action=edit
     * @param wikiText the completely wiki text
     */
    private void es_v_conj_zc_cer( String wikiText ) {
        Properties props = BookUtils.parseRule( wikiText, "es.v.conj.zc.cer", 0 );
        if( props != null ) {
            String w1 = props.getProperty( "1", "{{{1}}}" );
            String w2 = props.getProperty( "2", "" );

            props.put( "irregular", "x" );
            if( props.getProperty( "nexo", "" ).length() == 0 ) {
                props.put( "nexo", "c" );
            }

            //presente de indicativo
            props.put( "i.p.1s", w1 + "zco" );

            //presente de subjuntivo
            props.put( "s.p.1s", w1 + "zca" );
            props.put( "s.p.2s", w1 + "zcas" );
            props.put( "s.p.2s2", w1 + "zcs" );
            props.put( "s.p.3s", w1 + "zca" );
            props.put( "s.p.1p", w1 + "zcamos" );
            props.put( "s.p.2p", w1 + "zcis" );
            props.put( "s.p.3p", w1 + "zcan" );
            if( w2.length() > 0 ) {
                props.put( "im.3s", w2 + "zcase" );
                props.put( "im.1p", w1 + "zcmonos" );
                props.put( "im.3p", w2 + "zcanse" );
            } else {
                props.put( "im.3s", w1 + "zcase" );
                props.put( "im.1p", w1 + "zcamos" );
                props.put( "im.3p", w1 + "zcan" );
            }

            es_v_conj_er( props );
        }
    }

    /**
     * http://es.wiktionary.org/w/index.php?title=Plantilla:es.v.conj.eer&action=edit
     * @param wikiText the completely wiki text
     */
    private void es_v_conj_eer( String wikiText ) {
        Properties props = BookUtils.parseRule( wikiText, "es.v.conj.eer", 0 );
        if( props != null ) {
            String w1 = props.getProperty( "1", "{{{1}}}" );

            props.put( "irregular", "x" );

            props.put( "i.pp.1s", w1 + "" );
            props.put( "i.pp.2s", w1 + "ste" );
            props.put( "i.pp.3s", w1 + "y" );
            props.put( "i.pp.1p", w1 + "jimos" );
            props.put( "i.pp.2p", w1 + "steis" );
            props.put( "i.pp.3p", w1 + "yeron" );

            //subjuntivo

            props.put( "s.pi.1s", w1 + "yera" );
            props.put( "s.pi.2s", w1 + "yeras" );
            props.put( "s.pi.3s", w1 + "yera" );
            props.put( "s.pi.1p", w1 + "yramos" );
            props.put( "s.pi.2p", w1 + "yerais" );
            props.put( "s.pi.3p", w1 + "yeran" );

            props.put( "s.pi2.1s", w1 + "yese" );
            props.put( "s.pi2.2s", w1 + "yeses" );
            props.put( "s.pi2.3s", w1 + "yese" );
            props.put( "s.pi2.1p", w1 + "ysemos" );
            props.put( "s.pi2.2p", w1 + "yeseis" );
            props.put( "s.pi2.3p", w1 + "yesen" );

            props.put( "s.f.1s", w1 + "yere" );
            props.put( "s.f.2s", w1 + "yeres" );
            props.put( "s.f.3s", w1 + "yere" );
            props.put( "s.f.1p", w1 + "yremos" );
            props.put( "s.f.2p", w1 + "yereis" );
            props.put( "s.f.3p", w1 + "yeren" );

            es_v_conj_er( props );
        }
    }

    /**
     * http://es.wiktionary.org/w/index.php?title=Plantilla:es.v.conj.ger&action=edit
     * @param wikiText the completely wiki text
     */
    private void es_v_conj_ger( String wikiText ) {
        Properties props = BookUtils.parseRule( wikiText, "es.v.conj.ger", 0 );
        if( props != null ) {
            props.put( "nexo", "g" );

            es_v_conj_er( props );
        }
    }

    /**
     * http://es.wiktionary.org/w/index.php?title=Plantilla:es.v.conj.caer&action=edit
     * @param wikiText the completely wiki text
     */
    private void es_v_conj_caer( String wikiText ) {
        Properties props = BookUtils.parseRule( wikiText, "es.v.conj.caer", 0 );
        if( props != null ) {
            String w1 = props.getProperty( "1", "{{{1}}}" );
            boolean pronominal = props.getProperty( "pronominal", "" ).length() > 0;

            props.put( "irregular", "x" );

            //primera persona singular presente
            props.put( "i.p.1s", w1 + "caigo" );

            props.put( "i.pp.3s", w1 + "cay" );
            props.put( "i.pp.3p", w1 + "cayeron" );

            //subjuntivo

            props.put( "s.p.1s", w1 + "caiga" );
            props.put( "s.p.2s", w1 + "caigas" );
            props.put( "s.p.2s2", w1 + "caigs" );
            props.put( "s.p.3s", w1 + "caiga" );
            props.put( "s.p.1p", w1 + "caigamos" );
            props.put( "s.p.2p", w1 + "caigis" );
            props.put( "s.p.3p", w1 + "caigan" );

            props.put( "s.pi.1s", w1 + "cayera" );
            props.put( "s.pi.2s", w1 + "cayeras" );
            props.put( "s.pi.3s", w1 + "cayera" );
            props.put( "s.pi.1p", w1 + "cayramos" );
            props.put( "s.pi.2p", w1 + "cayerais" );
            props.put( "s.pi.3p", w1 + "cayeran" );

            props.put( "s.pi2.1s", w1 + "cayese" );
            props.put( "s.pi2.2s", w1 + "cayeses" );
            props.put( "s.pi2.3s", w1 + "cayese" );
            props.put( "s.pi2.1p", w1 + "caysemos" );
            props.put( "s.pi2.2p", w1 + "cayeseis" );
            props.put( "s.pi2.3p", w1 + "cayesen" );

            props.put( "s.f.1s", w1 + "cayere" );
            props.put( "s.f.2s", w1 + "cayeres" );
            props.put( "s.f.3s", w1 + "cayere" );
            props.put( "s.f.1p", w1 + "cayremos" );
            props.put( "s.f.2p", w1 + "cayereis" );
            props.put( "s.f.3p", w1 + "cayeren" );

            //imperativo
            if( pronominal ) {
                props.put( "im.3s", w1 + "cigase" );
                props.put( "im.1p", w1 + "caigmonos" );
                props.put( "im.3p", w1 + "ciganse" );
            } else {
                props.put( "im.3s", w1 + "caiga" );
                props.put( "im.1p", w1 + "caigamos" );
                props.put( "im.3p", w1 + "caigan" );
            }

            es_v_conj_er( props );
        }
    }

    /**
     * http://es.wiktionary.org/w/index.php?title=Plantilla:es.v.conj.hacer&action=edit
     * @param wikiText the completely wiki text
     */
    private void es_v_conj_hacer( String wikiText ) {
        Properties props = BookUtils.parseRule( wikiText, "es.v.conj.hacer", 0 );
        if( props != null ) {
            String w1 = props.getProperty( "1", "{{{1}}}" );
            boolean pronominal = props.getProperty( "pronominal", "" ).length() > 0;

            props.put( "irregular", "x" );
            props.put( "1", w1 + "ac" );
            props.put( "2", w1 + "c" );

            props.put( "i.p.1s", w1 + "ago" );

            props.put( "i.pp.1s", w1 + "ice" );
            props.put( "i.pp.2s", w1 + "iciste" );
            props.put( "i.pp.3s", w1 + "izo" );
            props.put( "i.pp.1p", w1 + "icimos" );
            props.put( "i.pp.2p", w1 + "icisteis" );
            props.put( "i.pp.3p", w1 + "icieron" );

            props.put( "i.f.1s", w1 + "ar" );
            props.put( "i.f.2s", w1 + "ars" );
            props.put( "i.f.3s", w1 + "ar" );
            props.put( "i.f.1p", w1 + "aremos" );
            props.put( "i.f.2p", w1 + "aris" );
            props.put( "i.f.3p", w1 + "arn" );

            props.put( "i.c.1s", w1 + "ara" );
            props.put( "i.c.2s", w1 + "aras" );
            props.put( "i.c.3s", w1 + "ara" );
            props.put( "i.c.1p", w1 + "aramos" );
            props.put( "i.c.2p", w1 + "arais" );
            props.put( "i.c.3p", w1 + "aran" );

            //subjuntivo

            props.put( "s.p.1s", w1 + "aga" );
            props.put( "s.p.2s", w1 + "agas" );
            props.put( "s.p.2s2", w1 + "ags" );
            props.put( "s.p.3s", w1 + "aga" );
            props.put( "s.p.1p", w1 + "agamos" );
            props.put( "s.p.2p", w1 + "agis" );
            props.put( "s.p.3p", w1 + "agan" );

            props.put( "s.pi.1s", w1 + "iciera" );
            props.put( "s.pi.2s", w1 + "icieras" );
            props.put( "s.pi.3s", w1 + "iciera" );
            props.put( "s.pi.1p", w1 + "iciramos" );
            props.put( "s.pi.2p", w1 + "icierais" );
            props.put( "s.pi.3p", w1 + "icieran" );

            props.put( "s.pi2.1s", w1 + "iciese" );
            props.put( "s.pi2.2s", w1 + "icieses" );
            props.put( "s.pi2.3s", w1 + "iciese" );
            props.put( "s.pi2.1p", w1 + "icisemos" );
            props.put( "s.pi2.2p", w1 + "icieseis" );
            props.put( "s.pi2.3p", w1 + "iciesen" );

            props.put( "s.f.1s", w1 + "iciere" );
            props.put( "s.f.2s", w1 + "icieres" );
            props.put( "s.f.3s", w1 + "iciere" );
            props.put( "s.f.1p", w1 + "iciremos" );
            props.put( "s.f.2p", w1 + "iciereis" );
            props.put( "s.f.3p", w1 + "icieren" );

            //imperativo
            if( pronominal ) {
                props.put( "im.2s", w1 + "azte" );
                props.put( "im.3s", w1 + "gase" );
                props.put( "im.1p", w1 + "agmonos" );
                props.put( "im.3p", w1 + "ganse" );
            } else {
                props.put( "im.2s", w1 + "az" );
                props.put( "im.3s", w1 + "aga" );
                props.put( "im.1p", w1 + "agamos" );
                props.put( "im.3p", w1 + "agan" );
            }

            es_v_conj_er( props );
        }
    }

    /**
     * http://es.wiktionary.org/w/index.php?title=Plantilla:es.v.conj.poner&action=edit
     * @param wikiText the completely wiki text
     */
    private void es_v_conj_poner( String wikiText ) {
        Properties props = BookUtils.parseRule( wikiText, "es.v.conj.poner", 0 );
        if( props != null ) {
            String w1 = props.getProperty( "1", "{{{1}}}" );
            boolean pronominal = props.getProperty( "pronominal", "" ).length() > 0;

            props.put( "irregular", "x" );
            props.put( "1", w1 + "pon" );
            props.put( "2", w1 + "pn" );

            props.put( "i.p.1s", w1 + "pongo" );
            props.put( "i.pp.1s", w1 + "puse" );
            props.put( "i.pp.2s", w1 + "pusiste" );
            props.put( "i.pp.3s", w1 + "puso" );
            props.put( "i.pp.1p", w1 + "pusimos" );
            props.put( "i.pp.2p", w1 + "pusisteis" );
            props.put( "i.pp.3p", w1 + "pusieron" );

            props.put( "i.f.1s", w1 + "pondr" );
            props.put( "i.f.2s", w1 + "pondrs" );
            props.put( "i.f.3s", w1 + "pondr" );
            props.put( "i.f.1p", w1 + "pondremos" );
            props.put( "i.f.2p", w1 + "pondris" );
            props.put( "i.f.3p", w1 + "pondrn" );

            props.put( "i.c.1s", w1 + "pondra" );
            props.put( "i.c.2s", w1 + "pondras" );
            props.put( "i.c.3s", w1 + "pondra" );
            props.put( "i.c.1p", w1 + "pondramos" );
            props.put( "i.c.2p", w1 + "pondrais" );
            props.put( "i.c.3p", w1 + "pondran" );

            props.put( "s.p.1s", w1 + "ponga" );
            props.put( "s.p.2s", w1 + "pongas" );
            props.put( "s.p.2s2", w1 + "pongs" );
            props.put( "s.p.3s", w1 + "ponga" );
            props.put( "s.p.1p", w1 + "pongamos" );
            props.put( "s.p.2p", w1 + "pongis" );
            props.put( "s.p.3p", w1 + "pongan" );
            props.put( "s.pi.1s", w1 + "pusiera" );
            props.put( "s.pi.2s", w1 + "pusieras" );
            props.put( "s.pi.3s", w1 + "pusiera" );
            props.put( "s.pi.1p", w1 + "pusiramos" );
            props.put( "s.pi.2p", w1 + "pusierais" );
            props.put( "s.pi.3p", w1 + "pusieran" );
            props.put( "s.pi2.1s", w1 + "pusiese" );
            props.put( "s.pi2.2s", w1 + "pusieses" );
            props.put( "s.pi2.3s", w1 + "pusiese" );
            props.put( "s.pi2.1p", w1 + "pusisemos" );
            props.put( "s.pi2.2p", w1 + "pusieseis" );
            props.put( "s.pi2.3p", w1 + "pusiesen" );
            props.put( "s.f.1s", w1 + "pusiere" );
            props.put( "s.f.2s", w1 + "pusieres" );
            props.put( "s.f.3s", w1 + "pusiere" );
            props.put( "s.f.1p", w1 + "pusiremos" );
            props.put( "s.f.2p", w1 + "pusiereis" );
            props.put( "s.f.3p", w1 + "pusieren" );

            //imperativo
            if( pronominal ) {
                props.put( "im.2s", w1 + "ponte" );
                addWord( w1 + "pnete" );
                props.put( "im.3s", w1 + "pngase" );
                props.put( "im.1p", w1 + "pongmonos" );
                props.put( "im.3p", w1 + "pnganse" );
            } else {
                props.put( "im.2s", w1 + "pn" );
                addWord( w1 + "pone" );
                props.put( "im.3s", w1 + "ponga" );
                props.put( "im.1p", w1 + "pongamos" );
                props.put( "im.3p", w1 + "pongan" );
            }

            es_v_conj_er( props );
        }
    }

    /**
     * http://es.wiktionary.org/w/index.php?title=Plantilla:es.v.conj.tener&action=edit
     * @param wikiText the completely wiki text
     */
    private void es_v_conj_tener( String wikiText ) {
        Properties props = BookUtils.parseRule( wikiText, "es.v.conj.tener", 0 );
        if( props != null ) {
            String w1 = props.getProperty( "1", "{{{1}}}" );
            boolean pronominal = props.getProperty( "pronominal", "" ).length() > 0;

            props.put( "irregular", "x" );
            props.put( "1", w1 + "ten" );
            props.put( "2", w1 + "tn" );

            props.put( "i.p.1s", w1 + "tengo" );
            props.put( "i.p.2s", w1 + "tienes" );
            props.put( "i.p.3s", w1 + "tiene" );
            props.put( "i.p.3p", w1 + "tienen" );

            props.put( "i.pp.1s", w1 + "tuve" );
            props.put( "i.pp.2s", w1 + "tuviste" );
            props.put( "i.pp.3s", w1 + "tuvo" );
            props.put( "i.pp.1p", w1 + "tuvimos" );
            props.put( "i.pp.2p", w1 + "tuvisteis" );
            props.put( "i.pp.3p", w1 + "tuvieron" );

            props.put( "i.f.1s", w1 + "tendr" );
            props.put( "i.f.2s", w1 + "tendrs" );
            props.put( "i.f.3s", w1 + "tendr" );
            props.put( "i.f.1p", w1 + "tendremos" );
            props.put( "i.f.2p", w1 + "tendris" );
            props.put( "i.f.3p", w1 + "tendrn" );

            props.put( "i.c.1s", w1 + "tendra" );
            props.put( "i.c.2s", w1 + "tendras" );
            props.put( "i.c.3s", w1 + "tendra" );
            props.put( "i.c.1p", w1 + "tendramos" );
            props.put( "i.c.2p", w1 + "tendrais" );
            props.put( "i.c.3p", w1 + "tendran" );

            //subjuntivo

            props.put( "s.p.1s", w1 + "tenga" );
            props.put( "s.p.2s", w1 + "tengas" );
            props.put( "s.p.2s2", w1 + "tengs" );
            props.put( "s.p.3s", w1 + "tenga" );
            props.put( "s.p.1p", w1 + "tengamos" );
            props.put( "s.p.2p", w1 + "tengis" );
            props.put( "s.p.3p", w1 + "tengan" );

            props.put( "s.pi.1s", w1 + "tuviera" );
            props.put( "s.pi.2s", w1 + "tuvieras" );
            props.put( "s.pi.3s", w1 + "tuviera" );
            props.put( "s.pi.1p", w1 + "tuviramos" );
            props.put( "s.pi.2p", w1 + "tuvierais" );
            props.put( "s.pi.3p", w1 + "tuvieran" );

            props.put( "s.pi2.1s", w1 + "tuviese" );
            props.put( "s.pi2.2s", w1 + "tuvieses" );
            props.put( "s.pi2.3s", w1 + "tuviese" );
            props.put( "s.pi2.1p", w1 + "tuvisemos" );
            props.put( "s.pi2.2p", w1 + "tuvieseis" );
            props.put( "s.pi2.3p", w1 + "tuviesen" );

            props.put( "s.f.1s", w1 + "tuviere" );
            props.put( "s.f.2s", w1 + "tuvieres" );
            props.put( "s.f.3s", w1 + "tuviere" );
            props.put( "s.f.1p", w1 + "tuviremos" );
            props.put( "s.f.2p", w1 + "tuviereis" );
            props.put( "s.f.3p", w1 + "tuvieren" );

            //imperativo
            if( pronominal ) {
                props.put( "im.2s=", w1 + "tnte" );
                props.put( "im.3s", w1 + "tngase" );
                props.put( "im.1p", w1 + "tengmonos" );
                props.put( "im.3p", w1 + "tnganse" );
            } else {
                props.put( "im.2s=", w1 + "tn" );
                props.put( "im.3s", w1 + "tenga" );
                props.put( "im.1p", w1 + "tengamos" );
                props.put( "im.3p", w1 + "tengan" );
            }

            es_v_conj_er( props );
        }
    }

    /**
     * http://es.wiktionary.org/w/index.php?title=Plantilla:es.v.conj.traer&action=edit
     * @param wikiText the completely wiki text
     */
    private void es_v_conj_traer( String wikiText ) {
        Properties props = BookUtils.parseRule( wikiText, "es.v.conj.traer", 0 );
        if( props != null ) {
            String w1 = props.getProperty( "1", "{{{1}}}" );
            boolean pronominal = props.getProperty( "pronominal", "" ).length() > 0;

            props.put( "irregular", "x" );
            props.put( "1", w1 + "tra" );
            props.put( "2", w1 + "tr" );

            props.put( "i.p.1s", w1 + "traigo" );

            props.put( "i.pp.1s", w1 + "traje" );
            props.put( "i.pp.2s", w1 + "trajiste" );
            props.put( "i.pp.3s", w1 + "trajo" );
            props.put( "i.pp.1p", w1 + "trajimos" );
            props.put( "i.pp.2p", w1 + "trajisteis" );
            props.put( "i.pp.3p", w1 + "trajeron" );

            //subjuntivo

            props.put( "s.p.1s", w1 + "traiga" );
            props.put( "s.p.2s", w1 + "traigas" );
            props.put( "s.p.2s2", w1 + "traigs" );
            props.put( "s.p.3s", w1 + "traiga" );
            props.put( "s.p.1p", w1 + "traigamos" );
            props.put( "s.p.2p", w1 + "traigis" );
            props.put( "s.p.3p", w1 + "traigan" );

            props.put( "s.pi.1s", w1 + "trajera" );
            props.put( "s.pi.2s", w1 + "trajeras" );
            props.put( "s.pi.3s", w1 + "trajera" );
            props.put( "s.pi.1p", w1 + "trajramos" );
            props.put( "s.pi.2p", w1 + "trajerais" );
            props.put( "s.pi.3p", w1 + "trajeran" );

            props.put( "s.pi2.1s", w1 + "trajese" );
            props.put( "s.pi2.2s", w1 + "trajeses" );
            props.put( "s.pi2.3s", w1 + "trajese" );
            props.put( "s.pi2.1p", w1 + "trajsemos" );
            props.put( "s.pi2.2p", w1 + "trajeseis" );
            props.put( "s.pi2.3p", w1 + "trajesen" );

            props.put( "s.f.1s", w1 + "trajere" );
            props.put( "s.f.2s", w1 + "trajeres" );
            props.put( "s.f.3s", w1 + "trajere" );
            props.put( "s.f.1p", w1 + "trajremos" );
            props.put( "s.f.2p", w1 + "trajereis" );
            props.put( "s.f.3p", w1 + "trajeren" );

            //imperativo
            if( pronominal ) {
                props.put( "im.3s", w1 + "trigase" );
                props.put( "im.1p", w1 + "traigmonos" );
                props.put( "im.3p", w1 + "triganse" );
            } else {
                props.put( "im.3s", w1 + "traiga" );
                props.put( "im.1p", w1 + "traigamos" );
                props.put( "im.3p", w1 + "traigan" );
            }

            es_v_conj_er( props );
        }
    }

    /**
     * http://es.wiktionary.org/w/index.php?title=Plantilla:es.v.conj.er&action=edit
     * @param props parsed parameters, can not be null
     */
    private void es_v_conj_er( Properties props ) {
        String w1 = props.getProperty( "1", "{{{1}}}" );
        String nexo = props.getProperty( "nexo", "" );
        String part = props.getProperty( "part" );
        String part2 = props.getProperty( "part2" );
        boolean impersonal = props.getProperty( "impersonal", "" ).length() > 0; //plural or singular
        boolean impersonalPlural = "plural".equalsIgnoreCase( props.getProperty( "impersonal", "" ) );

        boolean pronominal = props.getProperty( "pronominal", "" ).length() > 0;

        addWord( w1 + nexo + "er" + (pronominal ? "se" : "") );
        addWord( w1 + nexo + "ido" );
        addWord( w1 + nexo + (pronominal ? "indose" : "iendo") ); // Simples Gerundio
        if( part != null ) {
            addWord( part );
        }
        if( part2 != null ) {
            addWord( part2 );
        }

        //indicativo presente
        if( !impersonal ) {
            addWord( props.getProperty( "i.p.1s", w1 + nexo + "o" ) );
            addWord( props.getProperty( "i.p.2s", w1 + nexo + "es" ) );
            addWord( props.getProperty( "i.p.2s2", w1 + nexo + "s" ) );
        }
        addWord( props.getProperty( "i.p.3s", w1 + nexo + "e" ) );
        if( !impersonal ) {
            addWord( props.getProperty( "i.p.1p", w1 + nexo + "emos" ) );
            addWord( props.getProperty( "i.p.2p", w1 + nexo + "is" ) );
        }
        addWord( props.getProperty( "i.p.3p", w1 + nexo + "en" ) );

        //imperfecto
        if( !impersonal ) {
            addWord( props.getProperty( "i.pi.1s", w1 + nexo + "a" ) );
            addWord( props.getProperty( "i.pi.2s", w1 + nexo + "as" ) );
        }
        addWord( props.getProperty( "i.pi.3s", w1 + nexo + "a" ) );
        if( !impersonal ) {
            addWord( props.getProperty( "i.pi.1p", w1 + nexo + "amos" ) );
            addWord( props.getProperty( "i.pi.2p", w1 + nexo + "ais" ) );
        }
        addWord( props.getProperty( "i.pi.3p", w1 + nexo + "an" ) );

        //indefinido
        if( !impersonal ) {
            addWord( props.getProperty( "i.pp.1s", w1 + nexo + "" ) );
            addWord( props.getProperty( "i.pp.2s", w1 + nexo + "iste" ) );
        }
        addWord( props.getProperty( "i.pp.3s", w1 + nexo + "i" ) );
        if( !impersonal ) {
            addWord( props.getProperty( "i.pp.1p", w1 + nexo + "imos" ) );
            addWord( props.getProperty( "i.pp.2p", w1 + nexo + "isteis" ) );
        }
        addWord( props.getProperty( "i.pp.3p", w1 + nexo + "ieron" ) );

        //futuro
        if( !impersonal ) {
            addWord( props.getProperty( "i.f.1s", w1 + nexo + "er" ) );
            addWord( props.getProperty( "i.f.2s", w1 + nexo + "ers" ) );
        }
        addWord( props.getProperty( "i.f.3s", w1 + nexo + "er" ) );
        if( !impersonal ) {
            addWord( props.getProperty( "i.f.1p", w1 + nexo + "eremos" ) );
            addWord( props.getProperty( "i.f.2p", w1 + nexo + "eris" ) );
        }
        addWord( props.getProperty( "i.f.3p", w1 + nexo + "ern" ) );

        //condicional
        if( !impersonal ) {
            addWord( props.getProperty( "i.c.1s", w1 + nexo + "era" ) );
            addWord( props.getProperty( "i.c.2s", w1 + nexo + "eras" ) );
        }
        addWord( props.getProperty( "i.c.3s", w1 + nexo + "era" ) );
        if( !impersonal ) {
            addWord( props.getProperty( "i.c.1p", w1 + nexo + "eramos" ) );
            addWord( props.getProperty( "i.c.2p", w1 + nexo + "erais" ) );
        }
        addWord( props.getProperty( "i.c.3p", w1 + nexo + "eran" ) );

        //subjuntivo presente
        if( !impersonal ) {
            addWord( props.getProperty( "s.p.1s", w1 + nexo + "a" ) );
            addWord( props.getProperty( "s.p.2s", w1 + nexo + "as" ) );
            addWord( props.getProperty( "s.p.2s2", w1 + nexo + "s" ) );
        }
        addWord( props.getProperty( "s.p.3s", w1 + nexo + "a" ) );
        if( !impersonal ) {
            addWord( props.getProperty( "s.p.1p", w1 + nexo + "amos" ) );
            addWord( props.getProperty( "s.p.2p", w1 + nexo + "is" ) );
        }
        addWord( props.getProperty( "s.p.3p", w1 + nexo + "an" ) );

        //imperfecto (-iera)
        if( !impersonal ) {
            addWord( props.getProperty( "s.pi.1s", w1 + nexo + "iera" ) );
            addWord( props.getProperty( "s.pi.2s", w1 + nexo + "ieras" ) );
        }
        addWord( props.getProperty( "s.pi.3s", w1 + nexo + "iera" ) );
        if( !impersonal ) {
            addWord( props.getProperty( "s.pi.1p", w1 + nexo + "iramos" ) );
            addWord( props.getProperty( "s.pi.2p", w1 + nexo + "ierais" ) );
        }
        addWord( props.getProperty( "s.pi.3p", w1 + nexo + "ieran" ) );

        //imperfecto (-iese)
        if( !impersonal ) {
            addWord( props.getProperty( "s.pi2.1s", w1 + nexo + "iese" ) );
            addWord( props.getProperty( "s.pi2.2s", w1 + nexo + "ieses" ) );
        }
        addWord( props.getProperty( "s.pi2.3s", w1 + nexo + "iese" ) );
        if( !impersonal ) {
            addWord( props.getProperty( "s.pi2.1p", w1 + nexo + "isemos" ) );
            addWord( props.getProperty( "s.pi2.2p", w1 + nexo + "ieseis" ) );
        }
        addWord( props.getProperty( "s.pi2.3p", w1 + nexo + "iesen" ) );

        //futuro
        if( !impersonal ) {
            addWord( props.getProperty( "s.f.1s", w1 + nexo + "iere" ) );
            addWord( props.getProperty( "s.f.2s", w1 + nexo + "ieres" ) );
        }
        addWord( props.getProperty( "s.f.3s", w1 + nexo + "iere" ) );
        if( !impersonal ) {
            addWord( props.getProperty( "s.f.1p", w1 + nexo + "iremos" ) );
            addWord( props.getProperty( "s.f.2p", w1 + nexo + "iereis" ) );
        }
        addWord( props.getProperty( "s.f.3p", w1 + nexo + "ieren" ) );

        //imperativo
        if( !impersonalPlural ) {
            addWord( props.getProperty( "im.2s", w1 + nexo + "e" ) );
            addWord( props.getProperty( "im.2s2", w1 + nexo + "" ) );
            addWord( props.getProperty( "im.2p", w1 + nexo + "ed" ) );
        }
    }

    /**
     * http://es.wiktionary.org/w/index.php?title=Plantilla:es.v.conj.ir&action=edit
     * @param wikiText the completely wiki text
     */
    private void es_v_conj_ir( String wikiText ) {
        Properties props = BookUtils.parseRule( wikiText, "es.v.conj.ir", 0 );
        if( props != null ) {
            es_v_conj_ir( props );
        }
    }

    /**
     * http://es.wiktionary.org/w/index.php?title=Plantilla:es.v.conj.cir&action=edit
     * @param wikiText the completely wiki text
     */
    private void es_v_conj_cir( String wikiText ) {
        Properties props = BookUtils.parseRule( wikiText, "es.v.conj.cir", 0 );
        if( props != null ) {
            props.put( "nexo", "c" );

            es_v_conj_ir( props );
        }
    }

    /**
     * http://es.wiktionary.org/w/index.php?title=Plantilla:es.v.conj.zc.cir&action=edit
     * @param wikiText the completely wiki text
     */
    private void es_v_conj_zc_cir( String wikiText ) {
        Properties props = BookUtils.parseRule( wikiText, "es.v.conj.zc.cir", 0 );
        if( props != null ) {
            String w1 = props.getProperty( "1", "{{{1}}}" );
            String w2 = props.getProperty( "2", "" );

            props.put( "irregular", "x" );
            props.put( "nexo", "c" );

            props.put( "i.p.1s", w1 + "zco" );
            //presente de subjuntivo
            props.put( "s.p.1s", w1 + "zca" );
            props.put( "s.p.2s", w1 + "zcas" );
            props.put( "s.p.2s2", w1 + "zcs" );
            props.put( "s.p.3s", w1 + "zca" );
            props.put( "s.p.1p", w1 + "zcamos" );
            props.put( "s.p.2p", w1 + "zcis" );
            props.put( "s.p.3p", w1 + "zcan" );

            //imperativo
            if( w2.length() > 0 ) {
                props.put( "im.3s", w2 + "zcase" );
                props.put( "im.1p", w1 + "zcmonos" );
                props.put( "im.3p", w2 + "zcanse" );
            } else {
                props.put( "im.3s", w1 + "zca" );
                props.put( "im.1p", w1 + "zcamos" );
                props.put( "im.3p", w1 + "zcan" );
            }

            es_v_conj_ir( props );
        }
    }

    /**
     * http://es.wiktionary.org/w/index.php?title=Plantilla:es.v.conj.decir&action=edit
     * @param wikiText the completely wiki text
     */
    private void es_v_conj_decir( String wikiText ) {
        Properties props = BookUtils.parseRule( wikiText, "es.v.conj.decir", 0 );
        if( props != null ) {
            String w1 = props.getProperty( "1", "{{{1}}}" );
            String w2 = props.getProperty( "2", "" );
            boolean pronominal = props.getProperty( "pronominal", "" ).length() > 0;

            props.put( "irregular", "si" );
            props.put( "1", w1 + "dec" );
            if( pronominal ) {
                props.put( "2", w1 + "dg" );
            }

            props.put( "i.p.1s", w1 + "digo" );
            props.put( "i.p.2s", w1 + "dices" );
            props.put( "i.p.3s", w1 + "dice" );
            props.put( "i.p.3p", w1 + "dicen" );

            props.put( "i.pp.1s", w1 + "dije" );
            props.put( "i.pp.2s", w1 + "dijiste" );
            props.put( "i.pp.3s", w1 + "dijo" );
            props.put( "i.pp.1p", w1 + "dijimos" );
            props.put( "i.pp.2p", w1 + "dijisteis" );
            props.put( "i.pp.3p", w1 + "dijeron" );

            props.put( "i.f.1s", w1 + "dir" );
            props.put( "i.f.2s", w1 + "dirs" );
            props.put( "i.f.3s", w1 + "dir" );
            props.put( "i.f.1p", w1 + "diremos" );
            props.put( "i.f.2p", w1 + "diris" );
            props.put( "i.f.3p", w1 + "dirn" );

            props.put( "i.c.1s", w1 + "dira" );
            props.put( "i.c.2s", w1 + "diras" );
            props.put( "i.c.3s", w1 + "dira" );
            props.put( "i.c.1p", w1 + "diramos" );
            props.put( "i.c.2p", w1 + "dirais" );
            props.put( "i.c.3p", w1 + "diran" );

            props.put( "s.p.1s", w1 + "diga" );
            props.put( "s.p.2s", w1 + "digas" );
            props.put( "s.p.2s2", w1 + "digs" );
            props.put( "s.p.3s", w1 + "diga" );
            props.put( "s.p.1p", w1 + "digamos" );
            props.put( "s.p.2p", w1 + "digis" );
            props.put( "s.p.3p", w1 + "digan" );

            props.put( "s.pi.1s", w1 + "dijera" );
            props.put( "s.pi.2s", w1 + "dijeras" );
            props.put( "s.pi.3s", w1 + "dijera" );
            props.put( "s.pi.1p", w1 + "dijramos" );
            props.put( "s.pi.2p", w1 + "dijerais" );
            props.put( "s.pi.3p", w1 + "dijeran" );

            props.put( "s.pi2.1s", w1 + "dijese" );
            props.put( "s.pi2.2s", w1 + "dijeses" );
            props.put( "s.pi2.3s", w1 + "dijese" );
            props.put( "s.pi2.1p", w1 + "dijsemos" );
            props.put( "s.pi2.2p", w1 + "dijeseis" );
            props.put( "s.pi2.3p", w1 + "dijesen" );

            props.put( "s.f.1s", w1 + "dijere" );
            props.put( "s.f.2s", w1 + "dijeres" );
            props.put( "s.f.3s", w1 + "dijere" );
            props.put( "s.f.1p", w1 + "dijremos" );
            props.put( "s.f.2p", w1 + "dijereis" );
            props.put( "s.f.3p", w1 + "dijeren" );

            props.put( "im.2s", w1 + "di" );
            props.put( "im.1p", w1 + "digamos" );

            es_v_conj_ir( props );
        }
    }

    /**
     * http://es.wiktionary.org/w/index.php?title=Plantilla:es.v.conj.gir&action=edit
     * @param wikiText the completely wiki text
     */
    private void es_v_conj_gir( String wikiText ) {
        Properties props = BookUtils.parseRule( wikiText, "es.v.conj.gir", 0 );
        if( props != null ) {
            props.put( "nexo", "g" );

            es_v_conj_ir( props );
        }
    }

    /**
     * http://es.wiktionary.org/w/index.php?title=Plantilla:es.v.conj.-ie-i-ue-u-.ir&action=edit
     * @param wikiText the completely wiki text
     */
    private void es_v_conj_ie_i_ue_ir( String wikiText ) {
        Properties props = BookUtils.parseRule( wikiText, "es.v.conj.-ie-i-ue-u-.ir", 0 );
        if( props != null ) {
            es_v_conj_ie_i_ue_ir( props );
        }
    }

    /**
     * http://es.wiktionary.org/w/index.php?title=Plantilla:es.v.conj.-ie-i-ue-u-.ir&action=edit
     * @param wikiText the completely wiki text
     */
    private void es_v_conj_ie_i_ue_ir( Properties props ) {
        String w2 = props.getProperty( "2", "{{{2}}}" );
        String w3 = props.getProperty( "3", "{{{3}}}" );
        String w4 = props.getProperty( "4", "{{{4}}}" );
        String nexo = props.getProperty( "nexo", "" );
        boolean pronominal = props.getProperty( "pronominal", "" ).length() > 0;

        props.put( "irregular", "x" );

        //presente de indicativo
        props.put( "i.p.1s", w2 + nexo + "o" );
        props.put( "i.p.2s", w2 + nexo + "es" );
        props.put( "i.p.3s", w2 + nexo + "e" );
        props.put( "i.p.3p", w2 + nexo + "en" );

        //pretrito perfecto simple de indicativo
        props.put( "i.pp.3s", w3 + nexo + "i" );
        props.put( "i.pp.3p", w3 + nexo + "ieron" );

        //presente de subjuntivo
        props.put( "s.p.1s", w2 + nexo + "a" );
        props.put( "s.p.2s", w2 + nexo + "as" );
        props.put( "s.p.2s2", w3 + nexo + "s" );
        props.put( "s.p.3s", w2 + nexo + "a" );
        props.put( "s.p.1p", w3 + nexo + "amos" );
        props.put( "s.p.2p", w3 + nexo + "is" );
        props.put( "s.p.3p", w2 + nexo + "an" );

        //subjuntivo imperfecto (-iera) 
        props.put( "s.pi.1s", w3 + nexo + "iera" );
        props.put( "s.pi.2s", w3 + nexo + "ieras" );
        props.put( "s.pi.3s", w3 + nexo + "iera" );
        props.put( "s.pi.1p", w3 + nexo + "iramos" );
        props.put( "s.pi.2p", w3 + nexo + "ierais" );
        props.put( "s.pi.3p", w3 + nexo + "ieran" );

        //subjuntivo imperfecto (-iese)
        props.put( "s.pi2.1s", w3 + nexo + "iese" );
        props.put( "s.pi2.2s", w3 + nexo + "ieses" );
        props.put( "s.pi2.3s", w3 + nexo + "iese" );
        props.put( "s.pi2.1p", w3 + nexo + "isemos" );
        props.put( "s.pi2.2p", w3 + nexo + "ieseis" );
        props.put( "s.pi2.3p", w3 + nexo + "iesen" );

        //subjuntivo futuro (-iere)
        props.put( "s.f.1s", w3 + nexo + "iere" );
        props.put( "s.f.2s", w3 + nexo + "ieres" );
        props.put( "s.f.3s", w3 + nexo + "iere" );
        props.put( "s.f.1p", w3 + nexo + "iremos" );
        props.put( "s.f.2p", w3 + nexo + "iereis" );
        props.put( "s.f.3p", w3 + nexo + "ieren" );

        //imperativo
        if( pronominal ) {
            props.put( "im.2s", w4 + nexo + "ete]]|[[{{{2}}}{{{nexo|}}}e" );
            props.put( "im.3s", w4 + nexo + "ase]]|[[{{{3}}}{{mutacion.es.nexo.ei|{{{nexo|}}}}}a" );
            props.put( "im.1p", w3 + nexo + "monos]]|[[{{{2}}}{{mutacion.es.nexo.ei|{{{nexo|}}}}}amos" );
            props.put( "im.3p", w4 + nexo + "anse]]|[[{{{3}}}{{mutacion.es.nexo.ei|{{{nexo|}}}}}an" );
        } else {
            props.put( "im.2s", w2 + nexo + "e" );
            props.put( "im.3s", w3 + nexo + "a" );
            props.put( "im.1p", w2 + nexo + "amos" );
            props.put( "im.3p", w3 + nexo + "an" );
        }

        es_v_conj_ir( props );

    }

    /**
     * http://es.wiktionary.org/w/index.php?title=Plantilla:es.v.conj.ir&action=edit
     * @param wikiText the completely wiki text
     */
    private void es_v_conj_nir( String wikiText ) {
        Properties props = BookUtils.parseRule( wikiText, "es.v.conj.ir", 0 );
        if( props != null ) {
            String w1 = props.getProperty( "1", "{{{1}}}" );

            props.put( "irregular", "x" );

            //pretrito indefinido
            props.put( "i.pp.3s", w1 + "" );
            props.put( "i.pp.3p", w1 + "eron" );

            //subjuntivo imperfecto (-iera) 
            props.put( "s.pi.1s", w1 + "era" );
            props.put( "s.pi.2s", w1 + "eras" );
            props.put( "s.pi.3s", w1 + "era" );
            props.put( "s.pi.1p", w1 + "ramos" );
            props.put( "s.pi.2p", w1 + "erais" );
            props.put( "s.pi.3p", w1 + "eran" );

            //subjuntivo imperfecto (-iese) 
            props.put( "s.pi2.1s", w1 + "ese" );
            props.put( "s.pi2.2s", w1 + "eses" );
            props.put( "s.pi2.3s", w1 + "ese" );
            props.put( "s.pi2.1p", w1 + "semos" );
            props.put( "s.pi2.2p", w1 + "eseis" );
            props.put( "s.pi2.3p", w1 + "esen" );

            //subjuntivo futuro (-iere) 
            props.put( "s.f.1s", w1 + "ere" );
            props.put( "s.f.2s", w1 + "eres" );
            props.put( "s.f.3s", w1 + "ere" );
            props.put( "s.f.1p", w1 + "remos" );
            props.put( "s.f.2p", w1 + "ereis" );
            props.put( "s.f.3p", w1 + "eren" );

            es_v_conj_ir( props );
        }
    }

    /**
     * http://es.wiktionary.org/w/index.php?title=Plantilla:es.v.conj.seguir&action=edit
     * @param wikiText the completely wiki text
     */
    private void es_v_conj_seguir( String wikiText ) {
        Properties props = BookUtils.parseRule( wikiText, "es.v.conj.seguir", 0 );
        if( props != null ) {
            String w1 = props.getProperty( "1", "{{{1}}}" );

            props.put( "1", w1 + "se" );
            props.put( "2", w1 + "si" );
            props.put( "3", w1 + "si" );
            props.put( "4", w1 + "s" );
            props.put( "nexo", w1 + "gu" );

            es_v_conj_ie_i_ue_ir( props );
        }
    }

    /**
     * http://es.wiktionary.org/w/index.php?title=Plantilla:es.v.conj.uir&action=edit
     * @param wikiText the completely wiki text
     */
    private void es_v_conj_uir( String wikiText ) {
        Properties props = BookUtils.parseRule( wikiText, "es.v.conj.uir", 0 );
        if( props != null ) {
            String w1 = props.getProperty( "1", "{{{1}}}" );
            String w2 = props.getProperty( "2", "{{{2}}}" );
            boolean pronominal = props.getProperty( "pronominal", "" ).length() > 0;

            props.put( "irregular", "x" );

            //presente de indicativo
            props.put( "i.p.1s", w1 + "yoo" );
            props.put( "i.p.2s", w1 + "yeses" );
            props.put( "i.p.2s2", w1 + "s" );
            props.put( "i.p.3s", w1 + "yee" );
            props.put( "i.p.2p", w1 + "s" );
            props.put( "i.p.3p", w1 + "yen" );

            //pretrito perfecto simple (indefinido)
            props.put( "i.pp.1s", w1 + "" );
            props.put( "i.pp.3s", w1 + "y" );
            props.put( "i.pp.3p", w1 + "yeron" );

            //presente de subjuntivo
            props.put( "s.p.1s", w1 + "ya" );
            props.put( "s.p.2s", w1 + "yas" );
            props.put( "s.p.2s2", w1 + "ys" );
            props.put( "s.p.3s", w1 + "ya" );
            props.put( "s.p.1p", w1 + "yamos" );
            props.put( "s.p.2p", w1 + "yis" );
            props.put( "s.p.3p", w1 + "yan" );

            //subjuntivo imperfecto (-iera) 
            props.put( "s.pi.1s", w1 + "yera" );
            props.put( "s.pi.2s", w1 + "yeras" );
            props.put( "s.pi.3s", w1 + "yera" );
            props.put( "s.pi.1p", w1 + "yramos" );
            props.put( "s.pi.2p", w1 + "yerais" );
            props.put( "s.pi.3p", w1 + "yeran" );

            //subjuntivo imperfecto (-iese) 
            props.put( "s.pi2.1s", w1 + "yese" );
            props.put( "s.pi2.2s", w1 + "yeses" );
            props.put( "s.pi2.3s", w1 + "yese" );
            props.put( "s.pi2.1p", w1 + "ysemos" );
            props.put( "s.pi2.2p", w1 + "yeseis" );
            props.put( "s.pi2.3p", w1 + "yesen" );

            //subjuntivo futuro (-iere) 
            props.put( "s.f.1s", w1 + "yere" );
            props.put( "s.f.2s", w1 + "yeres" );
            props.put( "s.f.3s", w1 + "yere" );
            props.put( "s.f.1p", w1 + "yremos" );
            props.put( "s.f.2p", w1 + "yereis" );
            props.put( "s.f.3p", w1 + "yeren" );

            //imperativo
            if( pronominal ) {
                props.put( "im.2s", w2 + "yete" );
                props.put( "im.2s2", w1 + "ite" );
                props.put( "im.3s", w2 + "yase" );
                props.put( "im.1p", w1 + "ymonos" );
                props.put( "im.3p", w2 + "yanse" );
            } else  {
                props.put( "im.2s", w1 + "ye" );
                props.put( "im.2s2", w1 + "" );
                props.put( "im.3s", w1 + "ya" );
                props.put( "im.1p", w1 + "yamos" );
                props.put( "im.3p", w2 + "yan" );
           }
            
           es_v_conj_ir( props );
        }
    }

    /**
     * http://es.wiktionary.org/w/index.php?title=Plantilla:es.v.conj.ir&action=edit
     * @param props parsed parameters, can not be null
     */
    private void es_v_conj_ir( Properties props ) {
        String w1 = props.getProperty( "1", "{{{1}}}" );
        String nexo = props.getProperty( "nexo", "" );
        String part = props.getProperty( "part" );
        String part2 = props.getProperty( "part2" );
        boolean impersonal = props.getProperty( "impersonal", "" ).length() > 0; //plural or singular
        boolean impersonalPlural = "plural".equalsIgnoreCase( props.getProperty( "impersonal", "" ) );

        boolean pronominal = props.getProperty( "pronominal", "" ).length() > 0;

        addWord( w1 + nexo + "ir" + (pronominal ? "se" : "") );
        addWord( w1 + nexo + "ito" );
        addWord( w1 + nexo + (pronominal ? "indose" : "iendo") ); // Simples Gerundio
        if( part != null ) {
            addWord( part );
        }
        if( part2 != null ) {
            addWord( part2 );
        }

        //indicativo presente
        if( !impersonal ) {
            addWord( props.getProperty( "i.p.1s", w1 + nexo + "o" ) );
            addWord( props.getProperty( "i.p.2s", w1 + nexo + "es" ) );
            addWord( props.getProperty( "i.p.2s2", w1 + nexo + "s" ) );
        }
        addWord( props.getProperty( "i.p.3s", w1 + nexo + "e" ) );
        if( !impersonal ) {
            addWord( props.getProperty( "i.p.1p", w1 + nexo + "imos" ) );
            addWord( props.getProperty( "i.p.2p", w1 + nexo + "s" ) );
        }
        addWord( props.getProperty( "i.p.3p", w1 + nexo + "en" ) );

        //imperfecto
        if( !impersonal ) {
            addWord( props.getProperty( "i.pi.1s", w1 + nexo + "a" ) );
            addWord( props.getProperty( "i.pi.2s", w1 + nexo + "as" ) );
        }
        addWord( props.getProperty( "i.pi.3s", w1 + nexo + "a" ) );
        if( !impersonal ) {
            addWord( props.getProperty( "i.pi.1p", w1 + nexo + "amos" ) );
            addWord( props.getProperty( "i.pi.2p", w1 + nexo + "ais" ) );
        }
        addWord( props.getProperty( "i.pi.3p", w1 + nexo + "an" ) );

        //indefinido
        if( !impersonal ) {
            addWord( props.getProperty( "i.pp.1s", w1 + nexo + "" ) );
            addWord( props.getProperty( "i.pp.2s", w1 + nexo + "iste" ) );
        }
        addWord( props.getProperty( "i.pp.3s", w1 + nexo + "i" ) );
        if( !impersonal ) {
            addWord( props.getProperty( "i.pp.1p", w1 + nexo + "imos" ) );
            addWord( props.getProperty( "i.pp.2p", w1 + nexo + "isteis" ) );
        }
        addWord( props.getProperty( "i.pp.3p", w1 + nexo + "ieron" ) );

        //futuro
        if( !impersonal ) {
            addWord( props.getProperty( "i.f.1s", w1 + nexo + "ir" ) );
            addWord( props.getProperty( "i.f.2s", w1 + nexo + "irs" ) );
        }
        addWord( props.getProperty( "i.f.3s", w1 + nexo + "ir" ) );
        if( !impersonal ) {
            addWord( props.getProperty( "i.f.1p", w1 + nexo + "iremos" ) );
            addWord( props.getProperty( "i.f.2p", w1 + nexo + "iris" ) );
        }
        addWord( props.getProperty( "i.f.3p", w1 + nexo + "irn" ) );

        //condicional
        if( !impersonal ) {
            addWord( props.getProperty( "i.c.1s", w1 + nexo + "ira" ) );
            addWord( props.getProperty( "i.c.2s", w1 + nexo + "iras" ) );
        }
        addWord( props.getProperty( "i.c.3s", w1 + nexo + "ira" ) );
        if( !impersonal ) {
            addWord( props.getProperty( "i.c.1p", w1 + nexo + "iramos" ) );
            addWord( props.getProperty( "i.c.2p", w1 + nexo + "irais" ) );
        }
        addWord( props.getProperty( "i.c.3p", w1 + nexo + "iran" ) );

        //subjuntivo presente
        if( !impersonal ) {
            addWord( props.getProperty( "s.p.1s", w1 + nexo + "a" ) );
            addWord( props.getProperty( "s.p.2s", w1 + nexo + "as" ) );
            addWord( props.getProperty( "s.p.2s2", w1 + nexo + "s" ) );
        }
        addWord( props.getProperty( "s.p.3s", w1 + nexo + "a" ) );
        if( !impersonal ) {
            addWord( props.getProperty( "s.p.1p", w1 + nexo + "amos" ) );
            addWord( props.getProperty( "s.p.2p", w1 + nexo + "is" ) );
        }
        addWord( props.getProperty( "s.p.3p", w1 + nexo + "an" ) );

        //imperfecto (-iera)
        if( !impersonal ) {
            addWord( props.getProperty( "s.pi.1s", w1 + nexo + "iera" ) );
            addWord( props.getProperty( "s.pi.2s", w1 + nexo + "ieras" ) );
        }
        addWord( props.getProperty( "s.pi.3s", w1 + nexo + "iera" ) );
        if( !impersonal ) {
            addWord( props.getProperty( "s.pi.1p", w1 + nexo + "iramos" ) );
            addWord( props.getProperty( "s.pi.2p", w1 + nexo + "ierais" ) );
        }
        addWord( props.getProperty( "s.pi.3p", w1 + nexo + "ieran" ) );

        //imperfecto (-iese)
        if( !impersonal ) {
            addWord( props.getProperty( "s.pi2.1s", w1 + nexo + "iese" ) );
            addWord( props.getProperty( "s.pi2.2s", w1 + nexo + "ieses" ) );
        }
        addWord( props.getProperty( "s.pi2.3s", w1 + nexo + "iese" ) );
        if( !impersonal ) {
            addWord( props.getProperty( "s.pi2.1p", w1 + nexo + "isemos" ) );
            addWord( props.getProperty( "s.pi2.2p", w1 + nexo + "ieseis" ) );
        }
        addWord( props.getProperty( "s.pi2.3p", w1 + nexo + "iesen" ) );

        //futuro
        if( !impersonal ) {
            addWord( props.getProperty( "s.f.1s", w1 + nexo + "iere" ) );
            addWord( props.getProperty( "s.f.2s", w1 + nexo + "ieres" ) );
        }
        addWord( props.getProperty( "s.f.3s", w1 + nexo + "iere" ) );
        if( !impersonal ) {
            addWord( props.getProperty( "s.f.1p", w1 + nexo + "iremos" ) );
            addWord( props.getProperty( "s.f.2p", w1 + nexo + "iereis" ) );
        }
        addWord( props.getProperty( "s.f.3p", w1 + nexo + "ieren" ) );

        //imperativo
        if( !impersonalPlural ) {
            addWord( props.getProperty( "im.2s", w1 + nexo + "e" ) );
            addWord( props.getProperty( "im.2s2", w1 + nexo + "" ) );
            addWord( props.getProperty( "im.2p", w1 + nexo + "id" ) );
        }
    }

    private void findRuleAndAddWords( String word, String wikiText, String rule, String[] endingName ) {
        findRuleAndAddWords( word, wikiText, rule, endingName, null );
    }

    private void findRuleAndAddWords( String word, String wikiText, String rule, String[] endingName, String[] ending1 ) {
        findRuleAndAddWords( word, wikiText, rule, endingName, ending1, null );
    }

    private void findRuleAndAddWords( String word, String wikiText, String rule, String[] endingName, String[] ending1, String[] ending2 ) {
        findRuleAndAddWords( word, wikiText, rule, endingName, ending1, ending2, null, null );
    }

    private void findRuleAndAddWords( String word, String wikiText, String rule, String[] endingName, String[] ending1, String[] ending2, String[] ending3, String[] ending4 ) {
        int idx = wikiText.indexOf( "{{" + rule + "}}" );
        if( idx < 0 ) {
            idx = wikiText.indexOf( "{{" + rule + "|" );
            if( idx < 0 ) {
                return;
            }
        }
        if( endingName != null ) {
            for( String ending : endingName ) {
                addWord( word + ending );
            }
        }
        if( ending1 == null ) {
            return;
        }
        idx += rule.length() + 3;
        int idx2 = wikiText.indexOf( "}}", idx );
        String params = wikiText.substring( idx, idx2 );

        StringTokenizer tok = new StringTokenizer( params, "|" );
        if( tok.hasMoreElements() ) {
            String first = tok.nextToken().trim();
            if( ending1 != null ) {
                for( String ending : ending1 ) {
                    addWord( first + ending );
                }
            }

            if( tok.hasMoreElements() ) {
                String second = tok.nextToken().trim();
                if( ending2 != null ) {
                    for( String ending : ending2 ) {
                        addWord( second + ending );
                    }
                }

                if( tok.hasMoreElements() ) {
                    String third = tok.nextToken().trim();
                    if( ending3 != null ) {
                        for( String ending : ending3 ) {
                            addWord( third + ending );
                        }
                    }

                    if( tok.hasMoreElements() ) {
                        String four = tok.nextToken().trim();
                        if( ending4 != null ) {
                            for( String ending : ending4 ) {
                                addWord( four + ending );
                            }
                        }
                    }
                }

            }
        }
    }

}

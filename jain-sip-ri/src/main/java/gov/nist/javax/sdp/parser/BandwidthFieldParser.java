/*
* Conditions Of Use
*
* This software was developed by employees of the National Institute of
* Standards and Technology (NIST), an agency of the Federal Government.
* Pursuant to title 15 Untied States Code Section 105, works of NIST
* employees are not subject to copyright protection in the United States
* and are considered to be in the public domain.  As a result, a formal
* license is not needed to use the software.
*
* This software is provided by NIST as a service and is expressly
* provided "AS IS."  NIST MAKES NO WARRANTY OF ANY KIND, EXPRESS, IMPLIED
* OR STATUTORY, INCLUDING, WITHOUT LIMITATION, THE IMPLIED WARRANTY OF
* MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, NON-INFRINGEMENT
* AND DATA ACCURACY.  NIST does not warrant or make any representations
* regarding the use of the software or the results thereof, including but
* not limited to the correctness, accuracy, reliability or usefulness of
* the software.
*
* Permission to use this software is contingent upon your acceptance
* of the terms of this agreement
*
* .
*
*/
package gov.nist.javax.sdp.parser;

import gov.nist.core.NameValue;
import gov.nist.javax.sdp.fields.BandwidthField;
import gov.nist.javax.sdp.fields.SDPField;

import java.text.ParseException;

/**
 * @author  deruelle
 * @version JAIN-SDP-PUBLIC-RELEASE $Revision: 1.6 $ $Date: 2009-07-17 18:57:15 $
 */
public class BandwidthFieldParser extends SDPParser {

    /** Creates new BandwidthFieldParser */
    public BandwidthFieldParser(String bandwidthField) {
        this.lexer = new Lexer("charLexer", bandwidthField);
    }

    public BandwidthField bandwidthField() throws ParseException {
        try {
            this.lexer.match('b');
            this.lexer.SPorHT();
            this.lexer.match('=');
            this.lexer.SPorHT();

            BandwidthField bandwidthField = new BandwidthField();

            NameValue nameValue = nameValue(':');
            String name = nameValue.getName();
            String value = (String) nameValue.getValueAsObject();

            bandwidthField.setBandwidth(Integer.parseInt(value.trim()));
            bandwidthField.setBwtype(name);

            this.lexer.SPorHT();
            return bandwidthField;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ParseException(lexer.getBuffer(), lexer.getPtr());
        }
    }

    public SDPField parse() throws ParseException {
        return this.bandwidthField();
    }

    /**
        public static void main(String[] args) throws ParseException {
            String bandwidth[] = {
                "b=X-YZ:128\n",
                "b=CT: 31\n",
                "b=AS:0 \n",
                            "b= AS:4\n"
                    };

            for (int i = 0; i < bandwidth.length; i++) {
                BandwidthFieldParser bandwidthFieldParser=new BandwidthFieldParser(
                    bandwidth[i] );
            System.out.println("toParse: " + bandwidth[i]);
            BandwidthField bandwidthField = bandwidthFieldParser.bandwidthField();
            System.out.println("encoded: " + bandwidthField.encode());
            }

        }
    **/
}
/*
 * $Log: not supported by cvs2svn $
 * Revision 1.5  2007/10/22 03:38:26  mranga
 * Issue number:
 * Obtained from:
 * Submitted by:  mranga
 * Reviewed by:   mranga
 *
 * Java 5 porting.
 *
 * Revision 1.4  2006/07/13 09:02:41  mranga
 * Issue number:
 * Obtained from:
 * Submitted by:  jeroen van bemmel
 * Reviewed by:   mranga
 * Moved some changes from jain-sip-1.2 to java.net
 *
 * CVS: ----------------------------------------------------------------------
 * CVS: Issue number:
 * CVS:   If this change addresses one or more issues,
 * CVS:   then enter the issue number(s) here.
 * CVS: Obtained from:
 * CVS:   If this change has been taken from another system,
 * CVS:   then name the system in this line, otherwise delete it.
 * CVS: Submitted by:
 * CVS:   If this code has been contributed to the project by someone else; i.e.,
 * CVS:   they sent us a patch or a set of diffs, then include their name/email
 * CVS:   address here. If this is your work then delete this line.
 * CVS: Reviewed by:
 * CVS:   If we are doing pre-commit code reviews and someone else has
 * CVS:   reviewed your changes, include their name(s) here.
 * CVS:   If you have not had it reviewed then delete this line.
 *
 * Revision 1.3  2006/06/19 06:47:26  mranga
 * javadoc fixups
 *
 * Revision 1.2  2006/06/16 15:26:28  mranga
 * Added NIST disclaimer to all public domain files. Clean up some javadoc. Fixed a leak
 *
 * Revision 1.1.1.1  2005/10/04 17:12:34  mranga
 *
 * Import
 *
 *
 * Revision 1.2  2004/01/22 13:26:28  sverker
 * Issue number:
 * Obtained from:
 * Submitted by:  sverker
 * Reviewed by:   mranga
 *
 * Major reformat of code to conform with style guide. Resolved compiler and javadoc warnings. Added CVS tags.
 *
 * CVS: ----------------------------------------------------------------------
 * CVS: Issue number:
 * CVS:   If this change addresses one or more issues,
 * CVS:   then enter the issue number(s) here.
 * CVS: Obtained from:
 * CVS:   If this change has been taken from another system,
 * CVS:   then name the system in this line, otherwise delete it.
 * CVS: Submitted by:
 * CVS:   If this code has been contributed to the project by someone else; i.e.,
 * CVS:   they sent us a patch or a set of diffs, then include their name/email
 * CVS:   address here. If this is your work then delete this line.
 * CVS: Reviewed by:
 * CVS:   If we are doing pre-commit code reviews and someone else has
 * CVS:   reviewed your changes, include their name(s) here.
 * CVS:   If you have not had it reviewed then delete this line.
 *
 */

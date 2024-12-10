<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="html"/>
    <xsl:template match="/autok">
    
        <html>

            <head>
        	
        		<title>Miskolci autórndszámok</title>
        		
      		</head>
      		
            <body>
                <ul>
                    <xsl:for-each select="auto[tulaj/varos = 'Miskolc']">
                        <li>
                            <xsl:value-of select="@rsz" />
                        </li>
                    </xsl:for-each>
                </ul>
            </body>
            
        </html>
        
    </xsl:template>
</xsl:stylesheet>

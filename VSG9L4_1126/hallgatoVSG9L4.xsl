<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

  <xsl:output method="html" encoding="UTF-8" />

  <xsl:template match="/class">
  
    <html>
    
      <head>
      
        <title>Hallgatók</title>
        
        <style>
        
          body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #ffffff;
          }
          
          table {
            width: 50%;
            border-collapse: collapse;
          }
          th, td {
            border: 1px solid black;
            padding: 10px;
            text-align: center;
          }
          th {
            background-color: #8bd9f7;
          }
          
        </style>
      </head>
      <body>

        <table>
        
          <tr>
            <th>ID</th>
            <th>Vezetéknév</th>
            <th>Keresztnév</th>
            <th>Becenév</th>
            <th>Kor</th>
            <th>Ösztöndíj</th>
          </tr>

          <xsl:for-each select="student">
          
            <tr>
              <td><xsl:value-of select="@id" /></td>
              <td><xsl:value-of select="vezeteknev" /></td>
              <td><xsl:value-of select="keresztnev" /></td>
              <td><xsl:value-of select="becenev" /></td>
              <td><xsl:value-of select="kor" /></td>
              <td><xsl:value-of select="osztondij" /></td>
            </tr>
            
          </xsl:for-each>

        </table>
        
      </body>
      
    </html>
    
  </xsl:template>

</xsl:stylesheet>

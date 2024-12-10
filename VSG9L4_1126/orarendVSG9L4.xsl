<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

  <xsl:output method="html" encoding="UTF-8" />

  <xsl:template match="/KA_orarend">
  
    <html>
    
      <head>
      
        <title>Órarend</title>
        
        <style>
        
          body {
            display: flex;
            flex-direction: column;
            align-items: center;
            height: 100vh;
            background-color: #ffffff;
          }

          table {
            width: 70%;
            border-collapse: collapse;
            margin-top: 20px;
          }
          th, td {
            border: 1px solid black;
            padding: 10px;
            text-align: center;
          }
          th {
            background-color: #8bd9f7;
          }
          tr:nth-child(even) {
            background-color: #f2f2f2;
          }
          h1 {
            margin-top: 20px;
            text-align: center;
          }
          
        </style>
      </head>
      <body>
     	<h1>XY Órarend – 2023/24. I. félév</h1>
        <table>
        
          <tr>
            <th>ID</th>
            <th>Típus</th>
            <th>Tárgy</th>
            <th>Nap</th>
            <th>Időpont</th>
            <th>Helyszín</th>
            <th>Oktató</th>
            <th>Szak</th>
          </tr>

          <xsl:for-each select="ora">
          
            <tr>
              <td><xsl:value-of select="@id" /></td>
              <td><xsl:value-of select="@tipus" /></td>
              <td><xsl:value-of select="targy" /></td>
              <td><xsl:value-of select="idopont/nap" /></td>
              <td>
                <xsl:value-of select="idopont/tol" />-               
                <xsl:value-of select="idopont/ig" />
              </td>
              <td><xsl:value-of select="helyszin" /></td>
              <td><xsl:value-of select="oktato" /></td>
              <td><xsl:value-of select="szak" /></td>
            </tr>
            
          </xsl:for-each>

        </table>

      </body>
      
    </html>
    
  </xsl:template>

</xsl:stylesheet>

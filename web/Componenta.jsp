<%-- 
    Document   : HDD.jsp
    Created on : May 12, 2018, 12:22:27 PM
    Author     : Valentin
--%>


<%@page import="servlets.ComponentaServlet"%>
<%@page import="implementari.Sursa"%>
<%@page import="implementari.Procesor"%>
<%@page import="implementari.Memorie"%>
<%@page import="implementari.Placadebaza"%>
<%@page import="implementari.Componenta"%>
<%@page import="implementari.IOUtils"%>
<%@page import="implementari.HDD"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
  <meta charset="UTF-8">
  <title>Baza de date - Magazin PG</title>

      <link rel="stylesheet" href="style/style2.css">

  
</head>
    <body>
            
            <%
            ArrayList<HDD> hdd = IOUtils.readHDD();
            ArrayList<Memorie> mem = IOUtils.readMemorie();
            ArrayList<Placadebaza> placa = IOUtils.readPlacadebaza();
            ArrayList<Procesor> procesor = IOUtils.readProcesor();
            ArrayList<Sursa> sursa = IOUtils.readSursa();
        %>

         <table class="container">
            <thead>
                <tr>
                    <th>Cod Produs</th>
                    <th>Pret</th>
                    <th>Marca</th>
                    <th>AnFabricatie</th>
                    <th>Garantie</th>
                    <th>Producator</th>
                    <th>Tara Provenienta</th>
                    <th>Tip Componenta</th>
                    <th>Stoc</th>
                    <th>Adaugare Stoc</th>
                    <th>Scadere Stoc</th>
                    <th>OptiuneStergere</th>

                </tr>
            </thead>

            <%
                switch (ComponentaServlet.getSelectOption().toLowerCase()) {
                    case ("hdd"): {%>
                    <h2> In baza de date sunt inregistrate <%= hdd.size()%> hdd-uri </h2>

            <%
                        for (Componenta h : hdd) {
            %>



            <tbody>
                <tr>
                    <td> <%= h.getCodProdus()%></td>
                    <td> <%= h.getPret()%></td>
                    <td><%= h.getMarca()%> </td>
                    <td><%= h.getAnFabricatie()%> </td>
                    <td><%= h.getGarantie()%> </td>
                    <td> <%= h.getProducator()%> </td>
                    <td><%= h.getTaraProvenienta()%> </td>
                    <td><%= ComponentaServlet.getSelectOption()%> </td>
                    <td><%= h.getStoc()%> </td>

                    <td>
                        <form action ="AdaugareStoc" method="post">
                            <input type ="hidden" name="cod" value=<%=h.getCodProdus()%> />
                            <button type="submit">Adaugare Stoc</button>
                        </form>
                    </td>
                    <td>
                        <form action ="ScadereStoc" method="post">
                            <input type ="hidden" name="cod" value=<%=h.getCodProdus()%> />
                            <button type="submit">Scadere Stoc</button>
                        </form>
                    </td>
                    <td>
                        <form action ="StergeComponenta" method="post">
                            <input type ="hidden" name="cod" value=<%=h.getCodProdus()%> />
                            <button type="submit">Sterge produs</button>
                        </form>
                    </td>
                    
                </tr>

            </tbody>

            <%}
                            break;
                        }
                        case ("memorie"): {%>
            <div> In baza de date sunt inregistrate <%= mem.size()%> memorii </div>

            <%
                        for (Componenta h : mem) {%>
            <tbody>
                <tr>
                    <td> <%= h.getCodProdus()%></td>
                    <td> <%= h.getPret()%></td>
                    <td><%= h.getMarca()%> </td>
                    <td><%= h.getAnFabricatie()%> </td>
                    <td><%= h.getGarantie()%> </td>
                    <td> <%= h.getProducator()%> </td>
                    <td><%= h.getTaraProvenienta()%> </td>
                    <td><%= ComponentaServlet.getSelectOption()%> </td>
                    <td><%= h.getStoc()%> </td>

                    <td>
                        <form action ="AdaugareStoc" method="post">
                            <input type ="hidden" name="cod" value=<%=h.getCodProdus()%> />
                            <button type="submit">Adaugare Stoc</button>
                        </form>
                    </td>
                    <td>
                        <form action ="ScadereStoc" method="post">
                            <input type ="hidden" name="cod" value=<%=h.getCodProdus()%> />
                            <button type="submit">Scadere Stoc</button>
                        </form>
                    </td>
                    <td>
                        <form action ="StergeComponenta" method="post">
                            <input type ="hidden" name="cod" value=<%=h.getCodProdus()%> />
                            <button type="submit">Sterge produs</button>
                        </form>
                    </td>
                    
                </tr>

            </tbody>
            <%}
                            break;
                        }
                        case ("placadebaza"): {%>
            <div> In baza de date sunt inregistrate <%= placa.size()%> placi de baza </div>

            <%
                        for (Componenta h : placa) {%>
            <tbody>
                <tr>
                    <td> <%= h.getCodProdus()%></td>
                    <td> <%= h.getPret()%></td>
                    <td><%= h.getMarca()%> </td>
                    <td><%= h.getAnFabricatie()%> </td>
                    <td><%= h.getGarantie()%> </td>
                    <td> <%= h.getProducator()%> </td>
                    <td><%= h.getTaraProvenienta()%> </td>
                    <td><%= ComponentaServlet.getSelectOption()%> </td>
                    <td><%= h.getStoc()%> </td>

                    <td>
                        <form action ="AdaugareStoc" method="post">
                            <input type ="hidden" name="cod" value=<%=h.getCodProdus()%> />
                            <button type="submit">Adaugare Stoc</button>
                        </form>
                    </td>
                    <td>
                        <form action ="ScadereStoc" method="post">
                            <input type ="hidden" name="cod" value=<%=h.getCodProdus()%> />
                            <button type="submit">Scadere Stoc</button>
                        </form>
                    </td>
                    <td>
                        <form action ="StergeComponenta" method="post">
                            <input type ="hidden" name="cod" value=<%=h.getCodProdus()%> />
                            <button type="submit">Sterge produs</button>
                        </form>
                    </td>
                </tr>

            </tbody>
            <%}
                            break;
                        }
                        case ("procesor"): {%>
            <div> In baza de date sunt inregistrate <%= procesor.size()%> procesoare </div>

            <%
                        for (Componenta h : procesor) {%>
            <tbody>
                <tr>
                    <td> <%= h.getCodProdus()%></td>
                    <td> <%= h.getPret()%></td>
                    <td><%= h.getMarca()%> </td>
                    <td><%= h.getAnFabricatie()%> </td>
                    <td><%= h.getGarantie()%> </td>
                    <td> <%= h.getProducator()%> </td>
                    <td><%= h.getTaraProvenienta()%> </td>
                    <td><%= ComponentaServlet.getSelectOption()%> </td>
                    <td><%= h.getStoc()%> </td>

                    <td>
                        <form action ="AdaugareStoc" method="post">
                            <input type ="hidden" name="cod" value=<%=h.getCodProdus()%> />
                            <button type="submit">Adaugare Stoc</button>
                        </form>
                    </td>
                    <td>
                        <form action ="ScadereStoc" method="post">
                            <input type ="hidden" name="cod" value=<%=h.getCodProdus()%> />
                            <button type="submit">Scadere Stoc</button>
                        </form>
                    </td>
                    <td>
                        <form action ="StergeComponenta" method="post">
                            <input type ="hidden" name="cod" value=<%=h.getCodProdus()%> />
                            <button type="submit">Sterge produs</button>
                        </form>
                    </td>
                </tr>

            </tbody>
            <%}
                            break;
                        }
                        case ("sursa"): {%>
            <div> In baza de date sunt inregistrate <%= sursa.size()%> surse </div>

            <%
                        for (Componenta h : sursa) {%>
            <tbody>
                <tr>
                    <td> <%= h.getCodProdus()%></td>
                    <td> <%= h.getPret()%></td>
                    <td><%= h.getMarca()%> </td>
                    <td><%= h.getAnFabricatie()%> </td>
                    <td><%= h.getGarantie()%> </td>
                    <td> <%= h.getProducator()%> </td>
                    <td><%= h.getTaraProvenienta()%> </td>
                    <td><%= ComponentaServlet.getSelectOption()%> </td>
                    <td><%= h.getStoc()%> </td>

                    <td>
                        <form action ="AdaugareStoc" method="post">
                            <input type ="hidden" name="cod" value=<%=h.getCodProdus()%> />
                            <button type="submit">Adaugare Stoc</button>
                        </form>
                    </td>
                    <td>
                        <form action ="ScadereStoc" method="post">
                            <input type ="hidden" name="cod" value=<%=h.getCodProdus()%> />
                            <button type="submit">Scadere Stoc</button>
                        </form>
                    </td>
                    <td>
                        <form action ="StergeComponenta" method="post">
                            <input type ="hidden" name="cod" value=<%=h.getCodProdus()%> />
                            <button type="submit">Sterge produs</button>
                        </form>
                    </td>
                </tr>

            </tbody>
            <%}
                    break;
                }
                default: {
                            {%>
            <pre id="testResult" style="padding-left: 120px;"></pre>
            <div>Date incorecte introduse de la tastatura!</div>
            <br>
            <div>Tipul de componente corect poate fi doar: "hdd", "memorie", "placadebaza", "procesor" sau "sursa"</div>
            <%}
                    }
                }
            %>
        </table>
    </body>
</html>
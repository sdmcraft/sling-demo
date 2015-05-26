<%@taglib prefix="sling" uri="http://sling.apache.org/taglibs/sling" %>
<sling:defineObjects />
<p>Hello I am script1.</p>
<p>Currently I am rendering <%= resource.getName() %></p>
<p>Let's include another resource 'resource2' on this page</p>
<div style="background-color: grey;">
<sling:include path="/content/slingdemo/resource2.script2"/>
</div>
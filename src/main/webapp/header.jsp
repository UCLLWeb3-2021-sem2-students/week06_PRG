<header>
    <h1><span>Web shop</span></h1>
    <nav>
        <ul>
            <li ${param.title eq "Home"?'id="actual"':""} >
                <a href="Controller">Home</a></li>
            <li ${param.title eq "User Overview"?'id="actual"':""} >
                <a href="Controller?command=PersonOverview">Overview</a></li>
            <li ${param.title eq "Sign Up"?'id="actual"':""} >
                <a href="Controller?command=SignUp">Sign up</a></li>
        </ul>
    </nav>
    <h2>
        ${param.title}
    </h2>

</header>
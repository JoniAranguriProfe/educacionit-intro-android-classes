package com.educacionit.myfirstapp.screens.integrator_project

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.educacionit.myfirstapp.R

class TermsAndConditionsActivity : AppCompatActivity() {
    private lateinit var termsAndConditionsTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms_and_conditions)
        configureTermsViews()
    }

    private fun configureTermsViews() {
        termsAndConditionsTextView = findViewById(R.id.terms_and_conditions_content)
        termsAndConditionsTextView.text = TERMS_AND_CONDITIONS_CONTENT
    }

    companion object{
        const val TERMS_AND_CONDITIONS_CONTENT = """
    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam nunc diam, tincidunt vel bibendum sed, congue eget ante. Nulla ut volutpat tortor. Sed maximus, sem a malesuada placerat, mauris elit finibus erat, nec sagittis nisl enim eget lacus. Maecenas nec cursus arcu. Quisque et massa vel nisi porttitor pretium. Quisque eu elit tempor, faucibus lorem vitae, gravida justo. Morbi vitae pretium eros, in egestas metus. Nam sed laoreet nunc. Praesent vehicula lorem ac fermentum rutrum.

    Praesent lacus lectus, vehicula sed magna at, bibendum tempor nunc. Duis mattis consequat quam non bibendum. Mauris rhoncus dui augue, a luctus lorem bibendum non. Duis in facilisis turpis, placerat aliquam nulla. Praesent imperdiet sem sit amet magna maximus ultrices. Integer euismod est eget ex efficitur pretium. Aenean eu est massa. Etiam semper magna sapien. Aliquam erat volutpat. Proin rhoncus odio quis tempus sagittis. Vivamus dapibus faucibus enim, vitae bibendum ipsum lacinia ac. Vestibulum eget arcu leo. Vestibulum fermentum nibh vitae ipsum euismod, et commodo eros tempor. In ut tortor id urna pretium malesuada vel eget neque. Aliquam mauris ipsum, varius et ex sit amet, pharetra cursus massa.

    Sed dictum neque non venenatis condimentum. Cras quis condimentum sem. Integer in tincidunt neque. Suspendisse et mauris non lorem interdum commodo. Morbi tincidunt condimentum est, ut tristique magna varius in. Nunc ut iaculis orci. Phasellus eleifend tristique dui, quis egestas nunc pulvinar vitae. Cras lectus neque, aliquam a auctor eget, posuere non diam. Mauris eget aliquet nulla. Sed at ex ultricies, pharetra ante ut, vehicula erat. Vestibulum at dui iaculis dui molestie pulvinar. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nulla tempus lectus porta neque consequat porttitor. Donec leo magna, egestas ut augue sit amet, congue finibus est. Duis at eros risus. Integer eu est eu lacus cursus consectetur.

    Phasellus a est quis ligula sagittis feugiat. Pellentesque a tortor ipsum. Cras efficitur quam non eleifend varius. Etiam volutpat urna quis leo maximus, ut gravida est commodo. Phasellus et mi molestie, auctor eros a, condimentum eros. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Quisque viverra rhoncus orci. Praesent nunc leo, placerat vitae augue et, ultricies dignissim lorem. Curabitur aliquet lectus sit amet lacinia suscipit. Cras finibus nisi vel nisl pellentesque, id condimentum lacus sodales. Nullam sit amet mi nisl. Phasellus vel dui vel eros pharetra accumsan vitae id lacus. Aliquam commodo dignissim sagittis. In hac habitasse platea dictumst.

    Donec at massa id lorem fringilla interdum. Praesent tempor semper ligula, id venenatis quam sodales ut. Quisque a erat tellus. Nullam congue in ex eget faucibus. Etiam sagittis, elit ut pharetra efficitur, nunc purus laoreet ligula, rutrum gravida massa nibh sit amet ligula. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Ut et nulla nisl. Aliquam vel mi eu augue fermentum consectetur in vel odio. Praesent cursus, magna vitae convallis sodales, lectus quam eleifend felis, sit amet condimentum tellus elit in turpis.
        """
    }
}
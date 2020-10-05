# Generated by Django 3.1.1 on 2020-10-05 04:41

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('chat', '0002_capture'),
    ]

    operations = [
        migrations.AddField(
            model_name='chat',
            name='room',
            field=models.CharField(default=123, max_length=100),
            preserve_default=False,
        ),
        migrations.AlterField(
            model_name='chat',
            name='message',
            field=models.TextField(),
        ),
    ]
